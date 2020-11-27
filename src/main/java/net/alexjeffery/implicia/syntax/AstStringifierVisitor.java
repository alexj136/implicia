package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.syntax.visitor.AstVisitor;
import net.alexjeffery.implicia.syntax.visitor.DeclVisitor;
import net.alexjeffery.implicia.syntax.visitor.ExprVisitor;
import net.alexjeffery.implicia.syntax.visitor.TypeVisitor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public class AstStringifierVisitor implements AstVisitor<Void, String, RuntimeException> {

    @Override
    public String applyTo(List<Decl> decls, Void input) {
        if (decls.isEmpty())
            return "";
        StringBuilder out = new StringBuilder();
        out.append(decls.get(0).visit(declVisitor, null));
        for (int i = 1; i < decls.size(); i++) {
            out.append("\n").append(decls.get(i).visit(declVisitor, null));
        }
        return out.toString();
    }

    @Override
    public String applyTo(Decl decl, Void input) throws RuntimeException {
        return null;
    }

    private DeclStringifierVisitor declVisitor = new DeclStringifierVisitor();
    private ExprStringifierVisitor exprVisitor = new ExprStringifierVisitor();
    private TypeStringifierVisitor typeVisitor = new TypeStringifierVisitor();

    private static class DeclStringifierVisitor implements DeclVisitor<Void, String, RuntimeException> {

        @Override
        public String applyTo(@NotNull Decl.Alias alias, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(@NotNull Decl.Function function, Void input) throws RuntimeException {
            return null;
        }
    }

    @Override
    public String applyTo(Expr expr, Void input) throws RuntimeException {
        return null;
    }

    private static class ExprStringifierVisitor implements ExprVisitor<Void, String, RuntimeException> {

        @Override
        public String applyTo(Expr.Constant.Bool constant, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Constant.Int constant, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Constant.Char constant, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Constant.Numeric constant, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Constant.ListE constant, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.UnaryOp unaryOp, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.BinOp binOp, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Call call, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Lambda lambda, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Apply apply, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Expr.Variable variable, Void input) throws RuntimeException {
            return null;
        }
    }

    @Override
    public String applyTo(Type type, Void input) throws RuntimeException {
        return null;
    }

    private static class TypeStringifierVisitor implements TypeVisitor<Void, String, RuntimeException> {

        @Override
        public String applyTo(Type.Function function, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Int intT, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Bool bool, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Char charT, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Numeric numeric, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.ListT list, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Tuple tuple, Void input) throws RuntimeException {
            return null;
        }

        @Override
        public String applyTo(Type.Sum sum, Void input) throws RuntimeException {
            return null;
        }
    }
}
