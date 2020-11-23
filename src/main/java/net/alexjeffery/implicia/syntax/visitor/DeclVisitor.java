package net.alexjeffery.implicia.syntax.visitor;

import net.alexjeffery.implicia.syntax.Decl;

public interface DeclVisitor<I, O, X extends Throwable> extends Visitor<I, O, X> {
    public O applyTo(Decl.Function function, I input) throws X;

    public O applyTo(Decl.Alias alias, I input) throws X;
}
