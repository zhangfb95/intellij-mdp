package com.zhangfb95.plugins.mdp.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.zhangfb95.plugins.mdp.MdpLexerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.zhangfb95.plugins.mdp.highlighter.Colors.*;
import static com.zhangfb95.plugins.mdp.highlighter.TokenTypeSets.*;

/**
 * @author zhangfb
 */
public class MdpSyntaxHighlighter extends SyntaxHighlighterBase {

    protected static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        fillMap(ATTRIBUTES, COMMENT_SET, COMMENT_ATTR_KEY);
        fillMap(ATTRIBUTES, LINK_LEFT_PAREN_SET, LINK_LEFT_PAREN_ATTR_KEY);
        fillMap(ATTRIBUTES, LINK_RIGHT_PAREN_SET, LINK_RIGHT_PAREN_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_1_SET, HEADER_LEVEL_1_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_2_SET, HEADER_LEVEL_2_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_3_SET, HEADER_LEVEL_3_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_4_SET, HEADER_LEVEL_4_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_5_SET, HEADER_LEVEL_5_ATTR_KEY);
        fillMap(ATTRIBUTES, HEADER_LEVEL_6_SET, HEADER_LEVEL_6_ATTR_KEY);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MdpLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
