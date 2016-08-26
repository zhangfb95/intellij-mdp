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
INLINE_LINK=\[.*?\]\s*\(.*?\)
LINK_TEXT=[^[\[\]\(\)]]*
LINK_DESTINATION=[^[\[\]\(\)]]*
COMMENT="<!--" .* "-->"

%state INLINE_LINK, LINK_SHOW_TEXT, LINK_DESTINATION

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+             { return TokenType.WHITE_SPACE; }
    {COMMENT}                           { return COMMENT; }
    {INLINE_LINK}                       { yypushback(yytext().length()); yybegin(INLINE_LINK); }
}

<INLINE_LINK> {
    \[.*?\]                             { yypushback(yytext().length()); yybegin(LINK_SHOW_TEXT); }
    \(.*?\)                             { yypushback(yytext().length()); yybegin(LINK_DESTINATION); }
    \s*                                 { return TokenType.WHITE_SPACE; }
}

<LINK_SHOW_TEXT> {
    \[                                  { yybegin(LINK_SHOW_TEXT); return LEFT_BRACKET; }
    \]                                  { yybegin(LINK_DESTINATION); return RIGHT_BRACKET; }
    {LINK_TEXT}                         { yybegin(LINK_SHOW_TEXT); return LINK_TEXT; }
}

<LINK_DESTINATION> {
    \(                                  { yybegin(LINK_DESTINATION); return LEFT_PAREN; }
    \)                                  { yybegin(YYINITIAL); return RIGHT_PAREN; }
     {LINK_DESTINATION}                 { yybegin(LINK_DESTINATION); return LINK_REF; }
}

[^]                                     { return TokenType.WHITE_SPACE; }