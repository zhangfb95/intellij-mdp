package com.zhangfb95.plugins.mdp.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.zhangfb95.plugins.mdp.file.MdpFile;
import com.zhangfb95.plugins.mdp.file.MdpFileType;

/**
 * @author zhangfb
 */
public class MdpElementFactory {

    public static MdpWikiLinkRefPara createLinkRef(Project project, String name) {
        final MdpFile file = createFile(project, name);
        return (MdpWikiLinkRefPara) file.getChildren()[0].getChildren()[0].getChildren()[0].getChildren()[1].getChildren()[0];
        //return (MdpLinkRef) (file.getChildren()[3]);
    }

    public static MdpFile createFile(Project project, String text) {
        String name = "dummy.md";
        String sText = "[test]("+ text + ")";
        return (MdpFile) PsiFileFactory.getInstance(project).createFileFromText(name, MdpFileType.INSTANCE, sText);
    }
}
