package com.zhangfb95.plugins.mdp.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.BLOCK_COMMENT;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author zhangfb
 */
public class Colors {

    public static final TextAttributesKey COMMENT_ATTR_KEY = createKey("COMMENT", BLOCK_COMMENT);
    public static final TextAttributesKey ANY_ATTR_KEY = createKey("ANY");
    public static final TextAttributesKey WIKI_LINK_TEXT_START_ATTR_KEY = createKey("WIKI_LINK_TEXT_START");
    public static final TextAttributesKey WIKI_LINK_TEXT_ATTR_KEY = createKey("WIKI_LINK_TEXT");
    public static final TextAttributesKey WIKI_LINK_TEXT_END_ATTR_KEY = createKey("WIKI_LINK_TEXT_END");

    public static final TextAttributesKey WIKI_LINK_REF_START_ATTR_KEY = createKey("WIKI_LINK_REF_START");
    public static final TextAttributesKey WIKI_LINK_REF_ATTR_KEY = createKey("WIKI_LINK_REF");
    public static final TextAttributesKey WIKI_LINK_REF_END_ATTR_KEY = createKey("WIKI_LINK_REF_END");

    private static TextAttributesKey createKey(String key) {
        return createTextAttributesKey("MDP." + key);
    }

    private static TextAttributesKey createKey(String key, TextAttributesKey defaultKey) {
        return createTextAttributesKey("MDP." + key, defaultKey);
    }
}
