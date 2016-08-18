package com.zhangfb95.plugins.mdp.reference;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.zhangfb95.plugins.mdp.psi.MdpWikiLinkRefPara;

/**
 * @author zhangfb
 */
public class MdpRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(PsiElement element, PsiElement context) {
        return element instanceof MdpWikiLinkRefPara;
    }
}
