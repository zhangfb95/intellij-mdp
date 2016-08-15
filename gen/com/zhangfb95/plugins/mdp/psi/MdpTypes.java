// This is a generated file. Not intended for manual editing.
package com.zhangfb95.plugins.mdp.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.zhangfb95.plugins.mdp.psi.impl.*;

public interface MdpTypes {

  IElementType ELEMENT = new MdpElementType("ELEMENT");
  IElementType LINE = new MdpElementType("LINE");
  IElementType LINK = new MdpElementType("LINK");

  IElementType ANY = new MdpTokenType("ANY");
  IElementType COMMENT = new MdpTokenType("<!--\".*\"-->");
  IElementType CRLF = new MdpTokenType("CRLF");
  IElementType WIKI_LINK_END = new MdpTokenType("]");
  IElementType WIKI_LINK_REF = new MdpTokenType(".*");
  IElementType WIKI_LINK_SEPARATOR = new MdpTokenType("]\\s+(");
  IElementType WIKI_LINK_START = new MdpTokenType("[");
  IElementType WIKI_LINK_TEXT = new MdpTokenType("WIKI_LINK_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ELEMENT) {
        return new MdpElementImpl(node);
      }
      else if (type == LINE) {
        return new MdpLineImpl(node);
      }
      else if (type == LINK) {
        return new MdpLinkImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
