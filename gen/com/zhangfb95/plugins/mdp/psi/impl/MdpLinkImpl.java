// This is a generated file. Not intended for manual editing.
package com.zhangfb95.plugins.mdp.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.zhangfb95.plugins.mdp.psi.MdpTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.zhangfb95.plugins.mdp.psi.*;

public class MdpLinkImpl extends ASTWrapperPsiElement implements MdpLink {

  public MdpLinkImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MdpVisitor visitor) {
    visitor.visitLink(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MdpVisitor) accept((MdpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MdpLinkRef getLinkRef() {
    return findNotNullChildByClass(MdpLinkRef.class);
  }

  @Override
  @NotNull
  public MdpLinkText getLinkText() {
    return findNotNullChildByClass(MdpLinkText.class);
  }

}
