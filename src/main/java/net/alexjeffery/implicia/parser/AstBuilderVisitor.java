package net.alexjeffery.implicia.parser;

import net.alexjeffery.implicia.syntax.Term;
import net.alexjeffery.implicia.syntax.Type;

public class AstBuilderVisitor extends ImpliciaBaseVisitor<Term> {

    @Override public Term visitImplicia(ImpliciaParser.ImpliciaContext ctx) { return visitChildren(ctx); }
    @Override public Term visitFunctionTerm(ImpliciaParser.FunctionTermContext ctx) { return visitChildren(ctx); }
    @Override public Term visitApplicationTerm(ImpliciaParser.ApplicationTermContext ctx) { return visitChildren(ctx); }
    @Override public Term visitVariableTerm(ImpliciaParser.VariableTermContext ctx) { return visitChildren(ctx); }
    @Override public Term visitConstantTerm(ImpliciaParser.ConstantTermContext ctx) { return visitChildren(ctx); }
    @Override public Term visitMultipleArgs(ImpliciaParser.MultipleArgsContext ctx) { return visitChildren(ctx); }
    @Override public Term visitSingleArgs(ImpliciaParser.SingleArgsContext ctx) { return visitChildren(ctx); }
    @Override public Term visitMultipleTerms(ImpliciaParser.MultipleTermsContext ctx) { return visitChildren(ctx); }
    @Override public Term visitSingleTerms(ImpliciaParser.SingleTermsContext ctx) { return visitChildren(ctx); }
    @Override public Term visitNumberConstant(ImpliciaParser.NumberConstantContext ctx) { return visitChildren(ctx); }
    @Override public Term visitPlusConstant(ImpliciaParser.PlusConstantContext ctx) { return visitChildren(ctx); }

    @Override
    public Term visitIntType(ImpliciaParser.IntTypeContext ctx) {
        return new Type.Int();
    }

    @Override public Term visitNumericType(ImpliciaParser.NumericTypeContext ctx) { return visitChildren(ctx); }
    @Override public Term visitFunctionType(ImpliciaParser.FunctionTypeContext ctx) { return visitChildren(ctx); }
    @Override public Term visitMultipleTypes(ImpliciaParser.MultipleTypesContext ctx) { return visitChildren(ctx); }
    @Override public Term visitSingleTypes(ImpliciaParser.SingleTypesContext ctx) { return visitChildren(ctx); }

}
