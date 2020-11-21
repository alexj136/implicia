package net.alexjeffery.implicia.syntax;

public interface AstVisitor<I, O, X extends Throwable> {
    public O applyTo(Ast ast, I input) throws X;
}
