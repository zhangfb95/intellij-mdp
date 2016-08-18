package com.zhangfb95.plugins.mdp.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.ElementManipulator;
import com.intellij.util.IncorrectOperationException;
import com.zhangfb95.plugins.mdp.psi.MdpNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public class MdpNamedElementManipulator implements ElementManipulator<MdpNamedElement> {

    @Override
    public MdpNamedElement handleContentChange(@NotNull MdpNamedElement element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        if (!range.equalsToRange(0, element.getTextLength())) {
            throw new IncorrectOperationException();
        }
        return handleContentChange(element, newContent);
    }

    @Override
    public MdpNamedElement handleContentChange(@NotNull MdpNamedElement element, String newContent) throws IncorrectOperationException {
        element.setName(newContent);
        return element;
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull MdpNamedElement element) {
        return new TextRange(0, element.getTextLength());
    }
}
