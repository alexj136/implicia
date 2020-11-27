package net.alexjeffery.implicia.syntax.visitor;

import net.alexjeffery.implicia.syntax.Decl;
import net.alexjeffery.implicia.syntax.Expr;
import net.alexjeffery.implicia.syntax.Type;

import java.util.List;

public interface AstVisitor<I, O, X extends Throwable> extends Visitor<I, O, X> {
    public O applyTo(List<Decl> decls, I input) throws X;
    public O applyTo(Decl decl, I input) throws X;
    public O applyTo(Expr expr, I input) throws X;
    public O applyTo(Type type, I input) throws X;
}
