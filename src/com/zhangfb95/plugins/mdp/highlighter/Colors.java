package com.zhangfb95.plugins.mdp.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.BLOCK_COMMENT;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author zhangfb
 */
public class Colors {

    public static final TextAttributesKey COMMENT_ATTR_KEY = createKey("COMMENT", BLOCK_COMMENT);
    public static final TextAttributesKey LINK_LEFT_PAREN_ATTR_KEY = createKey("LINK_LEFT_PAREN");
    public static final TextAttributesKey LINK_RIGHT_PAREN_ATTR_KEY = createKey("LINK_RIGHT_PAREN");
    public static final TextAttributesKey HEADER_LEVEL_1_ATTR_KEY = createKey("HEADER_LEVEL_1");
    public static final TextAttributesKey HEADER_LEVEL_2_ATTR_KEY = createKey("HEADER_LEVEL_2");
    public static final TextAttributesKey HEADER_LEVEL_3_ATTR_KEY = createKey("HEADER_LEVEL_3");
    public static final TextAttributesKey HEADER_LEVEL_4_ATTR_KEY = createKey("HEADER_LEVEL_4");
    public static final TextAttributesKey HEADER_LEVEL_5_ATTR_KEY = createKey("HEADER_LEVEL_5");
    public static final TextAttributesKey HEADER_LEVEL_6_ATTR_KEY = createKey("HEADER_LEVEL_6");

    private static TextAttributesKey createKey(String key) {
        return createTextAttributesKey("MDP." + key);
    }

    private static TextAttributesKey createKey(String key, TextAttributesKey defaultKey) {
        return createTextAttributesKey("MDP." + key, defaultKey);
    }
}
