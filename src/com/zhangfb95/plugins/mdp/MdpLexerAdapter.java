package com.zhangfb95.plugins.mdp;

import com.intellij.lexer.FlexAdapter;

/**
 * @author zhangfb
 */
public class MdpLexerAdapter extends FlexAdapter {
    public MdpLexerAdapter() {
        super(new _MdpLexer(null));
    }
}
