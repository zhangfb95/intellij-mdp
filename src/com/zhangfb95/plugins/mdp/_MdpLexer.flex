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
WIKI_LINK_TEXT=[^[\[\]\(\)]]*
WIKI_LINK_REF=[^[\[\]\(\)]]*
COMMENT="<!--" .* "-->"

%state WIKI_LINK, WIKI_LINK_BEFORE, WIKI_LINK_AFTER

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+             { return TokenType.WHITE_SPACE; }
    {COMMENT}                           { return COMMENT; }
    {WIKI_LINK}                         { yypushback(yytext().length()); yybegin(WIKI_LINK); }
}

<WIKI_LINK> {
    \[.*?\]                             { yypushback(yytext().length()); yybegin(WIKI_LINK_BEFORE); }
    \(.*?\)                             { yypushback(yytext().length()); yybegin(WIKI_LINK_AFTER); }
    \s*                                 { return TokenType.WHITE_SPACE; }
}

<WIKI_LINK_BEFORE> {
    \[                                  { yybegin(WIKI_LINK_BEFORE); return WIKI_LINK_TEXT_START; }
    \]                                  { yybegin(WIKI_LINK); return WIKI_LINK_TEXT_END; }
    {WIKI_LINK_TEXT}                    { yybegin(WIKI_LINK_BEFORE); return WIKI_LINK_TEXT; }
}

<WIKI_LINK_AFTER> {
    \(                                  { yybegin(WIKI_LINK_AFTER); return WIKI_LINK_REF_START; }
    \)                                  { yybegin(YYINITIAL); return WIKI_LINK_REF_END; }
     {WIKI_LINK_REF}                    { yybegin(WIKI_LINK_AFTER); return WIKI_LINK_REF; }
}

[^]                                     { return TokenType.WHITE_SPACE; }