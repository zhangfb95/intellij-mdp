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
        fillMap(ATTRIBUTES, ANY_SET, ANY_ATTR_KEY);
        fillMap(ATTRIBUTES, WIKI_LINK_END_SET, WIKI_LINK_END_ATTR_KEY);
        fillMap(ATTRIBUTES, WIKI_LINK_REF_SET, WIKI_LINK_REF_ATTR_KEY);
        fillMap(ATTRIBUTES, WIKI_LINK_SEPARATOR_SET, WIKI_LINK_SEPARATOR_ATTR_KEY);
        fillMap(ATTRIBUTES, WIKI_LINK_START_SET, WIKI_LINK_START_ATTR_KEY);
        fillMap(ATTRIBUTES, WIKI_LINK_TEXT_SET, WIKI_LINK_TEXT_ATTR_KEY);
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
