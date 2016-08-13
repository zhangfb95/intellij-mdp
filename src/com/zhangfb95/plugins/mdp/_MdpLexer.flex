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
LINK_BEFORE=\[.*?\]
LINK_AFTER=\(.*?\)
COMMENT="<!--" .* "-->"
HEADER_LEVEL_1=#\s+.*
HEADER_LEVEL_2=##\s+.*
HEADER_LEVEL_3=###\s+.*
HEADER_LEVEL_4=####\s+.*
HEADER_LEVEL_5=#####\s+.*
HEADER_LEVEL_6=######\s+.*

%state WAITING_VALUE

%%

<YYINITIAL> {COMMENT}                                       { yybegin(YYINITIAL); return COMMENT; }
<YYINITIAL> {LINK_BEFORE}                                   { yybegin(YYINITIAL); return LINK_BEFORE; }
<YYINITIAL> {LINK_AFTER}                                    { yybegin(YYINITIAL); return LINK_AFTER; }
<YYINITIAL> {HEADER_LEVEL_1}                                { yybegin(YYINITIAL); return HEADER_LEVEL_1; }
<YYINITIAL> {HEADER_LEVEL_2}                                { yybegin(YYINITIAL); return HEADER_LEVEL_2; }
<YYINITIAL> {HEADER_LEVEL_3}                                { yybegin(YYINITIAL); return HEADER_LEVEL_3; }
<YYINITIAL> {HEADER_LEVEL_4}                                { yybegin(YYINITIAL); return HEADER_LEVEL_4; }
<YYINITIAL> {HEADER_LEVEL_5}                                { yybegin(YYINITIAL); return HEADER_LEVEL_5; }
<YYINITIAL> {HEADER_LEVEL_6}                                { yybegin(YYINITIAL); return HEADER_LEVEL_6; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.WHITE_SPACE; }
