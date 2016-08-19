package com.zhangfb95.plugins.mdp.reference;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.zhangfb95.plugins.mdp.file.MdpFile;
import com.zhangfb95.plugins.mdp.file.MdpFileType;
import com.zhangfb95.plugins.mdp.psi.MdpElement;
import com.zhangfb95.plugins.mdp.psi.MdpLine;
import com.zhangfb95.plugins.mdp.psi.MdpLink;
import com.zhangfb95.plugins.mdp.psi.MdpLinkRef;
import com.zhangfb95.plugins.mdp.psi.MdpWikiLinkRefPara;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangfb
 */
public class MdpReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private String key;

    public MdpReference(PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        key = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();

        List<MdpWikiLinkRefPara> list = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MdpFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            MdpFile mdpFile = (MdpFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (mdpFile != null) {
                List<MdpWikiLinkRefPara> properties = ss(mdpFile);
                if (properties != null) {
                    for (MdpWikiLinkRefPara property : properties) {
                        if (property != myElement) {
                            if (key.equals(property.getName())) {
                                list.add(property);
                            }
                        }
                    }
                }
            }
        }

        List<ResolveResult> results = new ArrayList<>();
        for (MdpWikiLinkRefPara property : list) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiFile cur = myElement.getContainingFile();
        String path = cur.getVirtualFile().getParent().getPath();
        String[] pathArray = key.split("/");
        for (String s : pathArray) {
            if (s != null && !"".equals(s.trim())) {
                path += File.separator;
                path += s;
            }
        }
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(path);
        if (virtualFile == null || !virtualFile.isDirectory()) {
            if (!path.endsWith(".md")) {
                path += ".md";
            }
        }
        virtualFile = LocalFileSystem.getInstance().findFileByPath(path);
        if (virtualFile != null) {
            PsiElement relate;
            if (virtualFile.isDirectory()) {
                relate = PsiManager.getInstance(myElement.getProject()).findDirectory(virtualFile);
            } else {
                relate = PsiManager.getInstance(myElement.getProject()).findFile(virtualFile);
            }
            if (relate != null) {
                return relate.getOriginalElement();
            }
        }
        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }


    private List<MdpWikiLinkRefPara> ss(MdpFile mdpFile) {
        List<MdpWikiLinkRefPara> list = new ArrayList<>();
        MdpElement[] elements = PsiTreeUtil.getChildrenOfType(mdpFile, MdpElement.class);
        if (elements != null && elements.length > 0) {
            for (MdpElement element : elements) {
                MdpLine[] mdpLines = PsiTreeUtil.getChildrenOfType(element, MdpLine.class);
                if (mdpLines != null && mdpLines.length > 0) {
                    for (MdpLine mdpLine : mdpLines) {
                        MdpLink[] mdpLinks = PsiTreeUtil.getChildrenOfType(mdpLine, MdpLink.class);
                        if (mdpLinks != null && mdpLinks.length > 0) {
                            for (MdpLink mdpLink : mdpLinks) {
                                MdpLinkRef[] mdpLinkRefs = PsiTreeUtil.getChildrenOfType(mdpLink, MdpLinkRef.class);
                                if (mdpLinkRefs != null && mdpLinkRefs.length > 0) {
                                    for (MdpLinkRef mdpLinkRef : mdpLinkRefs) {
                                        MdpWikiLinkRefPara[] mdpWikiLinkRefParas = PsiTreeUtil.getChildrenOfType(mdpLinkRef, MdpWikiLinkRefPara.class);
                                        if (mdpWikiLinkRefParas != null) {
                                            for (MdpWikiLinkRefPara mdpWikiLinkRefPara : mdpWikiLinkRefParas) {
                                                list.add(mdpWikiLinkRefPara);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
