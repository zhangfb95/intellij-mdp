package com.zhangfb95.plugins.mdp.highlighter;

import com.intellij.psi.tree.TokenSet;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;

/**
 * @author zhangfb
 */
public interface TokenTypeSets extends MdpTypes {

    TokenSet COMMENT_SET = TokenSet.create(COMMENT);
    TokenSet ANY_SET = TokenSet.create(ANY);
    TokenSet WIKI_LINK_END_SET = TokenSet.create(WIKI_LINK_END);
    TokenSet WIKI_LINK_REF_SET = TokenSet.create(WIKI_LINK_REF);
    TokenSet WIKI_LINK_SEPARATOR_SET = TokenSet.create(WIKI_LINK_SEPARATOR);
    TokenSet WIKI_LINK_START_SET = TokenSet.create(WIKI_LINK_START);
    TokenSet WIKI_LINK_TEXT_SET = TokenSet.create(WIKI_LINK_TEXT);
}
