// This is a generated file. Not intended for manual editing.
package com.zhangfb95.plugins.mdp.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.zhangfb95.plugins.mdp.psi.MdpTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MdpParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ELEMENT) {
      r = element(b, 0);
    }
    else if (t == LINE) {
      r = line(b, 0);
    }
    else if (t == LINK) {
      r = link(b, 0);
    }
    else if (t == LINK_REF) {
      r = link_ref(b, 0);
    }
    else if (t == LINK_TEXT) {
      r = link_text(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return mdpFile(b, l + 1);
  }

  /* ********************************************************** */
  // !<<eof>> (line)
  public static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    if (!nextTokenIs(b, "<element>", ANY, WIKI_LINK_TEXT_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT, "<element>");
    r = element_0(b, l + 1);
    r = r && element_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !<<eof>>
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (line)
  private static boolean element_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // element|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANY? link ANY?
  public static boolean line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line")) return false;
    if (!nextTokenIs(b, "<line>", ANY, WIKI_LINK_TEXT_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINE, "<line>");
    r = line_0(b, l + 1);
    r = r && link(b, l + 1);
    r = r && line_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ANY?
  private static boolean line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_0")) return false;
    consumeToken(b, ANY);
    return true;
  }

  // ANY?
  private static boolean line_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_2")) return false;
    consumeToken(b, ANY);
    return true;
  }

  /* ********************************************************** */
  // link_text SPACE? link_ref
  public static boolean link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link")) return false;
    if (!nextTokenIs(b, WIKI_LINK_TEXT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = link_text(b, l + 1);
    r = r && link_1(b, l + 1);
    r = r && link_ref(b, l + 1);
    exit_section_(b, m, LINK, r);
    return r;
  }

  // SPACE?
  private static boolean link_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_1")) return false;
    consumeToken(b, SPACE);
    return true;
  }

  /* ********************************************************** */
  // WIKI_LINK_REF_START WIKI_LINK_REF WIKI_LINK_REF_END
  public static boolean link_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_ref")) return false;
    if (!nextTokenIs(b, WIKI_LINK_REF_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WIKI_LINK_REF_START, WIKI_LINK_REF, WIKI_LINK_REF_END);
    exit_section_(b, m, LINK_REF, r);
    return r;
  }

  /* ********************************************************** */
  // WIKI_LINK_TEXT_START WIKI_LINK_TEXT WIKI_LINK_TEXT_END
  public static boolean link_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_text")) return false;
    if (!nextTokenIs(b, WIKI_LINK_TEXT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WIKI_LINK_TEXT_START, WIKI_LINK_TEXT, WIKI_LINK_TEXT_END);
    exit_section_(b, m, LINK_TEXT, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean mdpFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mdpFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mdpFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
