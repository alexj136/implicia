package net.alexjeffery.implicia.syntax;

public interface AstVisitor<I, O, X extends Throwable> {
    public O applyTo(Ast ast, I input) throws X;
    public O applyTo(Decl decl, I input) throws X;
    public O applyTo(Expr expr, I input) throws X;
    public O applyTo(Type type, I input) throws X;
}
