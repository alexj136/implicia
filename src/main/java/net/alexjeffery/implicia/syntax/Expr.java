package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Expr extends Ast {
    public static class Constant extends Expr {
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
            private BigDecimal value;
        }
        public static class List extends Constant { }
        public static class Concat extends Constant { }
        public static class Append extends Constant { }
        public static class Add extends Constant { }
        public static class Sub extends Constant { }
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
