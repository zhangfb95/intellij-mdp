package com.zhangfb95.plugins.mdp.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.zhangfb95.plugins.mdp.file.MdpFile;
import com.zhangfb95.plugins.mdp.file.MdpFileType;

/**
 * @author zhangfb
 */
public class MdpElementFactory {

    /*public static MdpProperty createProperty(Project project, String name) {
        final MdpFile file = createFile(project, name);
        return (MdpProperty) file.getFirstChild();
    }*/

    public static MdpFile createFile(Project project, String text) {
        String name = "dummy.simple";
        return (MdpFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, MdpFileType.INSTANCE, text);
    }
}
