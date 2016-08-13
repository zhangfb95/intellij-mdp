package com.zhangfb95.plugins.mdp.highlighter;

import com.intellij.psi.tree.TokenSet;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;

/**
 * @author zhangfb
 */
public interface TokenTypeSets extends MdpTypes {

    TokenSet COMMENT_SET = TokenSet.create(COMMENT);
    TokenSet LINK_LEFT_PAREN_SET = TokenSet.create(LINK_BEFORE);
    TokenSet LINK_RIGHT_PAREN_SET = TokenSet.create(LINK_AFTER);
    TokenSet HEADER_LEVEL_1_SET = TokenSet.create(HEADER_LEVEL_1);
    TokenSet HEADER_LEVEL_2_SET = TokenSet.create(HEADER_LEVEL_2);
    TokenSet HEADER_LEVEL_3_SET = TokenSet.create(HEADER_LEVEL_3);
    TokenSet HEADER_LEVEL_4_SET = TokenSet.create(HEADER_LEVEL_4);
    TokenSet HEADER_LEVEL_5_SET = TokenSet.create(HEADER_LEVEL_5);
    TokenSet HEADER_LEVEL_6_SET = TokenSet.create(HEADER_LEVEL_6);
}
