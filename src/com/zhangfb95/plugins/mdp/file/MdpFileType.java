package com.zhangfb95.plugins.mdp.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

/**
 * @author zhangfb
 */
public class MdpFileType extends LanguageFileType {

    public static final MdpFileType INSTANCE = new MdpFileType();

    private MdpFileType() {
        super(MdpLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Markdown file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "markdown file description";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "md";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MdpIcons.MDP;
    }
}
