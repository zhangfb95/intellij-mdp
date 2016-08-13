package com.zhangfb95.plugins.mdp.psi;

import com.intellij.psi.tree.IElementType;
import com.zhangfb95.plugins.mdp.file.MdpLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public class MdpTokenType extends IElementType {

    public MdpTokenType(@NotNull @NonNls String debugName) {
        super(debugName, MdpLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "MdpTokenType." + super.toString();
    }
}
