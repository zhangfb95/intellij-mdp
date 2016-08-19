package com.zhangfb95.plugins.mdp.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

/**
 * @author zhangfb
 */
public class MdpFile extends PsiFileBase {

    public MdpFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MdpLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MdpFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Markdown File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
