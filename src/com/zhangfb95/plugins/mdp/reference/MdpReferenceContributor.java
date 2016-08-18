package com.zhangfb95.plugins.mdp.reference;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.PsiReferenceRegistrar;
import com.intellij.util.ProcessingContext;
import com.zhangfb95.plugins.mdp.psi.MdpNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public class MdpReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(MdpNamedElement.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof MdpNamedElement && ((MdpNamedElement) element).getName() != null) {
                            return new PsiReference[]{element.getReference()};
                        } else {
                            return new PsiReference[0];
                        }
                    }
                });
    }
}
