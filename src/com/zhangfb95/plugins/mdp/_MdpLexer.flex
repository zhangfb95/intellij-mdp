package com.zhangfb95.plugins.mdp;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.zhangfb95.plugins.mdp.psi.MdpTypes.*;
import com.intellij.psi.TokenType;

%%

%{
  public _MdpLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MdpLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
WIKI_LINK=\[.*?\]\s*\(.*?\)
WIKI_LINK_START=\[
WIKI_LINK_TEXT=\[.*?\]
WIKI_LINK_SEPARATOR=\]\s+\(
WIKI_LINK_REF=\(.*?\)
WIKI_LINK_END=\)
COMMENT="<!--" .* "-->"

%state WIKI_LINK, WIKI_LINK_PRE

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+             { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
    {COMMENT}                           { yybegin(YYINITIAL); return COMMENT; }
    <YYINITIAL> {WIKI_LINK}             { yybegin(WIKI_LINK); return WIKI_LINK_TEXT; }
}

<WIKI_LINK> {
    {WIKI_LINK_TEXT}                    { yybegin(WIKI_LINK_PRE); }
    {WIKI_LINK_REF}                     { return WIKI_LINK_REF; }
    {WIKI_LINK_END}                     { yybegin(YYINITIAL); return WIKI_LINK_END; }
}

<WIKI_LINK_PRE> {
    {WIKI_LINK_START}                   { return WIKI_LINK_START; }
    {WIKI_LINK_SEPARATOR}               { yybegin(YYINITIAL); return WIKI_LINK_SEPARATOR; }
    [^]                                 { return WIKI_LINK_TEXT; }
}

[^]                                     { return TokenType.WHITE_SPACE; }