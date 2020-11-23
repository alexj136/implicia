package net.alexjeffery.implicia.syntax.visitor;

import net.alexjeffery.implicia.syntax.Expr;

public interface ExprVisitor<I, O, X extends Throwable> extends Visitor<I, O, X> {
    public O applyTo(Expr.Constant.Bool constant, I input) throws X;

    public O applyTo(Expr.Constant.Int constant, I input) throws X;

    public O applyTo(Expr.Constant.Char constant, I input) throws X;

    public O applyTo(Expr.Constant.Numeric constant, I input) throws X;

    public O applyTo(Expr.Constant.ListE constant, I input) throws X;

    public O applyTo(Expr.UnaryOp unaryOp, I input) throws X;

    public O applyTo(Expr.BinOp binOp, I input) throws X;

    public O applyTo(Expr.Call call, I input) throws X;

    public O applyTo(Expr.Lambda lambda, I input) throws X;

    public O applyTo(Expr.Apply apply, I input) throws X;

    public O applyTo(Expr.Variable variable, I input) throws X;
}
