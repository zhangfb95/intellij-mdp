package com.zhangfb95.plugins.mdp.file;

import com.intellij.lang.Language;

/**
 * @author zhangfb
 */
public class MdpLanguage extends Language {

    public static final MdpLanguage INSTANCE = new MdpLanguage();

    private MdpLanguage() {
        super("markdown");
    }
}
