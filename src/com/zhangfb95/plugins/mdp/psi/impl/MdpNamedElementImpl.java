package com.zhangfb95.plugins.mdp.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.zhangfb95.plugins.mdp.psi.MdpNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public abstract class MdpNamedElementImpl extends ASTWrapperPsiElement implements MdpNamedElement {

    public MdpNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
