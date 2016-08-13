package com.zhangfb95.plugins.mdp;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.zhangfb95.plugins.mdp.file.MdpFile;
import com.zhangfb95.plugins.mdp.file.MdpLanguage;
import com.zhangfb95.plugins.mdp.parser.MdpParser;
import com.zhangfb95.plugins.mdp.psi.MdpTypes;
import org.jetbrains.annotations.NotNull;


/**
 * @author zhangfb
 */
public class MdpParserDefinition implements ParserDefinition {

    public static final TokenSet COMMENT = TokenSet.create(MdpTypes.COMMENT);
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

    public static final IFileElementType FILE =
            new IFileElementType(Language.<MdpLanguage>findInstance(MdpLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new MdpLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENT;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new MdpParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new MdpFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return MdpTypes.Factory.createElement(node);
    }
}
