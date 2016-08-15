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
WIKI_LINK=\[.*?\]
WIKI_LINK_START=\[
WIKI_LINK_END=\]
WIKI_LINK_TEXT=[^[\[\]]]*
COMMENT="<!--" .* "-->"

%state WIKI_LINK, WIKI_LINK_PRE

%%
<YYINITIAL> {
    ({CRLF}|{WHITE_SPACE})+             { return TokenType.WHITE_SPACE; }
    {COMMENT}                           { return COMMENT; }
    {WIKI_LINK}                         { yypushback(yytext().length()); yybegin(WIKI_LINK); }
}

<WIKI_LINK> {
    {WIKI_LINK_START}                   { yybegin(WIKI_LINK); return WIKI_LINK_START; }
    {WIKI_LINK_END}                     { yybegin(YYINITIAL); return WIKI_LINK_END; }
    {WIKI_LINK_TEXT}                    { yybegin(WIKI_LINK); return WIKI_LINK_TEXT; }
}

[^]                                     { return TokenType.WHITE_SPACE; }