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

public class MdpElementImpl extends ASTWrapperPsiElement implements MdpElement {

  public MdpElementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MdpVisitor visitor) {
    visitor.visitElement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MdpVisitor) accept((MdpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MdpHeader getHeader() {
    return findChildByClass(MdpHeader.class);
  }

  @Override
  @Nullable
  public MdpLink getLink() {
    return findChildByClass(MdpLink.class);
  }

  @Override
  @Nullable
  public PsiElement getComment() {
    return findChildByType(COMMENT);
  }

}
