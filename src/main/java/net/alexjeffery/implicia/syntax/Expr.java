package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.syntax.visitor.ExprVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.misc.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Expr extends Ast {
    public <I, O, X extends Throwable> O visit(@NotNull ExprVisitor<I, O, X> visitor, @Nullable I input) throws X {
        return visitor.applyTo(this, input);
    }
    public static abstract class Constant extends Expr {
        public static Expr number(String parsedNumber) {
            return parsedNumber.contains(".")?
                    new Expr.Constant.Int(Integer.parseInt(parsedNumber)):
                    new Expr.Constant.Numeric(new BigDecimal(parsedNumber));
        }
        public static class Bool extends Constant {
            private boolean value;
            public Bool(boolean value) {
                this.value = value;
            }
        }
        public static class Int extends Constant {
            private int value;
            public Int(int value) {
                this.value = value;
            }
        }
        public static class Char extends Constant {
            private char value;
        }
        public static class Numeric extends Constant {
            @NotNull
            private BigDecimal value;
            public Numeric(@NotNull BigDecimal value) {
                this.value = value;
            }
        }
        public static class ListE extends Constant {
            @NotNull
            private List<Expr> elements;
            public ListE(List<Expr> elements) {
                this.elements = elements;
            }
        }
    }
    public static class UnaryOp extends Expr {
        @NotNull
        private UnaryOpType type;
        @NotNull
        private Expr argument;
        public UnaryOp(@NotNull UnaryOpType type, @NotNull Expr argument) {
            this.type = type;
            this.argument = argument;
        }
    }
    public static enum UnaryOpType {
        // boolean
        NOT,
    }
    public static class BinOp extends Expr {
        @NotNull
        private BinOpType type;
        @NotNull
        private Expr left;
        @NotNull
        private Expr right;
        public BinOp(@NotNull BinOpType type, @NotNull Expr left, @NotNull Expr right) {
            this.type = type;
            this.left = left;
            this.right = right;
        }
    }
    public static enum BinOpType {
        // arithmetic
        ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO, POWER,
        // comparison
        LT, GT, LE, GE, EQ, NE,
        // boolean
        AND, OR,
        // lists
        INDEX, CONCAT
    }
    public static class Call extends Expr {
        @NotNull
        private String name;
        @NotNull
        private List<Expr> arguments;
        public Call(@NotNull String name, @NotNull List<Expr> arguments) {
            this.name = name;
            this.arguments = arguments;
        }
    }
    public static class Lambda extends Expr {
        @NotNull
        private List<Pair<String, Type>> arguments;
        @NotNull
        private Expr body;
        public Lambda(@NotNull List<Pair<String, Type>> arguments, @NotNull Expr body) {
            this.arguments = arguments;
            this.body = body;
        }
    }
    public static class Apply extends Expr {
        @NotNull
        private Lambda lambda;
        @NotNull
        private List<Expr> arguments;
        public Apply(@NotNull Lambda lambda, @NotNull List<Expr> arguments) {
            this.lambda = lambda;
            this.arguments = arguments;
        }
    }
    public static class Variable extends Expr {
        @NotNull
        public final String name;
        public Variable(@NotNull String name) {
            this.name = name;
        }
    }
}
