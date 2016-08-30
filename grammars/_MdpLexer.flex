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
LINK_DESTINATION_NODE=[^[\<\>\/\[\]\(\)]]*
ATX= #{WHITE_SPACE}.*?
COMMENT="<!--" .* "-->"

%state INLINE_LINK, LINK_SHOW_TEXT, LINK_DESTINATION, LINK_DESTINATION_ANGLE_INNER, LINK_DESTINATION_FILE, S_ATX, S_ATX_HEADER, S_ATX_CONTENT

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+             { return TokenType.WHITE_SPACE; }
    {COMMENT}                           { return COMMENT; }
    {INLINE_LINK}                       { yypushback(yytext().length()); yybegin(INLINE_LINK); }
    {ATX}                               { yypushback(yytext().length()); yybegin(S_ATX); }
}

<INLINE_LINK> {
    \[.*?\]                             { yypushback(yytext().length()); yybegin(LINK_SHOW_TEXT); }
    \(.*?\)                             { yypushback(yytext().length()); yybegin(LINK_DESTINATION); }
    \s+                                 { return TokenType.WHITE_SPACE; }
}

<LINK_SHOW_TEXT> {
    \[                                  { yybegin(LINK_SHOW_TEXT); return LEFT_BRACKET; }
    {LINK_TEXT}                         { yybegin(LINK_SHOW_TEXT); return LINK_TEXT; }
    \]                                  { yybegin(LINK_DESTINATION); return RIGHT_BRACKET; }
}

<LINK_DESTINATION> {
    \<                                  { yybegin(LINK_DESTINATION); return LEFT_ANGLE; }
    \(                                  { yybegin(LINK_DESTINATION); return LEFT_PAREN; }
    {LINK_DESTINATION_NODE}             { yybegin(LINK_DESTINATION); return LINK_REF_DIR; }
    \/+                                 { yybegin(LINK_DESTINATION); return SLASH; }
    {LINK_DESTINATION_NODE}\)           { yypushback(yytext().length()); yybegin(LINK_DESTINATION_FILE); }
    \>                                  { yybegin(LINK_DESTINATION); return RIGHT_ANGLE; }
}

<LINK_DESTINATION_FILE> {
    {LINK_DESTINATION_NODE}             { yybegin(LINK_DESTINATION); return LINK_REF_FILE; }
    \)                                  { yybegin(YYINITIAL); return RIGHT_PAREN; }
}

<S_ATX> {
    #{WHITE_SPACE}                      { yybegin(S_ATX_HEADER); }
}

<S_ATX_HEADER> {
    #                                   { return ATX_HEADER; }
    {WHITE_SPACE}                       { yybegin(S_ATX_CONTENT); return TokenType.WHITE_SPACE; }
}

<S_ATX_CONTENT> {
    .*?                                 { yybegin(YYINITIAL); return ATX_CONTENT; }
}

[^]                                     { return TokenType.WHITE_SPACE; }