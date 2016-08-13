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

public class MdpHeaderImpl extends ASTWrapperPsiElement implements MdpHeader {

  public MdpHeaderImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MdpVisitor visitor) {
    visitor.visitHeader(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MdpVisitor) accept((MdpVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel1() {
    return findChildByType(HEADER_LEVEL_1);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel2() {
    return findChildByType(HEADER_LEVEL_2);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel3() {
    return findChildByType(HEADER_LEVEL_3);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel4() {
    return findChildByType(HEADER_LEVEL_4);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel5() {
    return findChildByType(HEADER_LEVEL_5);
  }

  @Override
  @Nullable
  public PsiElement getHeaderLevel6() {
    return findChildByType(HEADER_LEVEL_6);
  }

}
