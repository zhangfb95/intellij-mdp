package com.zhangfb95.plugins.mdp.reference;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.zhangfb95.plugins.mdp.MdpLexerAdapter;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;
import com.zhangfb95.plugins.mdp.psi.MdpWikiLinkRefPara;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author zhangfb
 */
public class MdpFindUsagesProvider implements FindUsagesProvider {

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new MdpLexerAdapter(),
                TokenSet.create(MdpTypes.WIKI_LINK_REF_PARA),
                TokenSet.create(MdpTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof MdpWikiLinkRefPara) {
            return "mdp property";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof MdpWikiLinkRefPara) {
            return ((MdpWikiLinkRefPara) element).getName();
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof MdpWikiLinkRefPara) {
            return ((MdpWikiLinkRefPara) element).getName() + ":" + ((MdpWikiLinkRefPara) element).getName();
        } else {
            return "";
        }
    }
}
