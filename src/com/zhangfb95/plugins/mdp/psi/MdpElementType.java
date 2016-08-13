package com.zhangfb95.plugins.mdp.psi;

import com.intellij.psi.tree.IElementType;
import com.zhangfb95.plugins.mdp.file.MdpLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public class MdpElementType extends IElementType {

    public MdpElementType(@NotNull @NonNls String debugName) {
        super(debugName, MdpLanguage.INSTANCE);
    }
}