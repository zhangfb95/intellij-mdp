package com.zhangfb95.plugins.mdp.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.zhangfb95.plugins.mdp.psi.MdpElementFactory;
import com.zhangfb95.plugins.mdp.psi.MdpLinkRef;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;
import com.zhangfb95.plugins.mdp.psi.MdpWikiLinkRefPara;

/**
 * @author zhangfb
 */
public class MdpPsiImplUtil {

    public static PsiElement setName(MdpWikiLinkRefParaImpl element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(MdpTypes.WIKI_LINK_REF);
        if (keyNode != null) {
            MdpWikiLinkRefPara property = MdpElementFactory.createLinkRef(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(MdpWikiLinkRefParaImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(MdpTypes.WIKI_LINK_REF);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getName(MdpWikiLinkRefParaImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(MdpTypes.WIKI_LINK_REF);
        if (keyNode != null) {
            return keyNode.getText().replaceAll("\\\\ ", " ");
        }
        return null;
    }
}
