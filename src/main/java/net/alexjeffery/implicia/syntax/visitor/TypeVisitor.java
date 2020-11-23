package net.alexjeffery.implicia.syntax.visitor;

import net.alexjeffery.implicia.syntax.Type;

public interface TypeVisitor<I, O, X extends Throwable> extends Visitor<I, O, X> {
    public O applyTo(Type.Function function, I input) throws X;

    public O applyTo(Type.Int intT, I input) throws X;

    public O applyTo(Type.Bool bool, I input) throws X;

    public O applyTo(Type.Char charT, I input) throws X;

    public O applyTo(Type.Numeric numeric, I input) throws X;

    public O applyTo(Type.ListT list, I input) throws X;

    public O applyTo(Type.Tuple tuple, I input) throws X;

    public O applyTo(Type.Sum sum, I input) throws X;
}
