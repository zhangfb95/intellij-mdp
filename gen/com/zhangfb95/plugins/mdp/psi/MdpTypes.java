// This is a generated file. Not intended for manual editing.
package com.zhangfb95.plugins.mdp.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zhangfb95.plugins.mdp.psi.impl.*;

public interface MdpTypes {

  IElementType ELEMENT = new MdpElementType("ELEMENT");
  IElementType HEADER = new MdpElementType("HEADER");
  IElementType LINK = new MdpElementType("LINK");

  IElementType ALL = new MdpTokenType(".*");
  IElementType COMMENT = new MdpTokenType("COMMENT");
  IElementType CRLF = new MdpTokenType("CRLF");
  IElementType HEADER_LEVEL_1 = new MdpTokenType("HEADER_LEVEL_1");
  IElementType HEADER_LEVEL_2 = new MdpTokenType("HEADER_LEVEL_2");
  IElementType HEADER_LEVEL_3 = new MdpTokenType("HEADER_LEVEL_3");
  IElementType HEADER_LEVEL_4 = new MdpTokenType("HEADER_LEVEL_4");
  IElementType HEADER_LEVEL_5 = new MdpTokenType("HEADER_LEVEL_5");
  IElementType HEADER_LEVEL_6 = new MdpTokenType("HEADER_LEVEL_6");
  IElementType LEFT_BRACKET = new MdpTokenType("[");
  IElementType LEFT_PAREN = new MdpTokenType("(");
  IElementType LINK_AFTER = new MdpTokenType("LINK_AFTER");
  IElementType LINK_BEFORE = new MdpTokenType("LINK_BEFORE");
  IElementType RIGHT_BRACKET = new MdpTokenType("]");
  IElementType RIGHT_PAREN = new MdpTokenType(")");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ELEMENT) {
        return new MdpElementImpl(node);
      }
      else if (type == HEADER) {
        return new MdpHeaderImpl(node);
      }
      else if (type == LINK) {
        return new MdpLinkImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
