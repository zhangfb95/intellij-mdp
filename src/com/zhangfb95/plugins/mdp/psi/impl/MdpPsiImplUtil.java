package com.zhangfb95.plugins.mdp.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.zhangfb95.plugins.mdp.psi.MdpElementFactory;
import com.zhangfb95.plugins.mdp.psi.MdpLinkRef;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;
import com.zhangfb95.plugins.mdp.psi.MdpWikiLinkRefPara;
import com.zhangfb95.plugins.mdp.reference.MdpReference;

/**
 * @author zhangfb
 */
public class MdpPsiImplUtil {

    public static PsiElement setName(MdpWikiLinkRefParaImpl element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(MdpTypes.WIKI_LINK_REF);
        if (keyNode != null) {
            String sourceName = element.getName();
            String suffix;
            if (sourceName.lastIndexOf("/") > 0) {
                suffix = sourceName.substring(0, sourceName.lastIndexOf("/") + 1);
            } else {
                suffix = "";
            }
            String newSuffixName = suffix + newName;
            MdpWikiLinkRefPara property = MdpElementFactory.createLinkRef(element.getProject(), newSuffixName);
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

    public static PsiReference getReference(MdpWikiLinkRefParaImpl element) {
        return new MdpReference(element, new TextRange(0, element.getNode().getTextLength()));
    }
}
