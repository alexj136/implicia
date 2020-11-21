package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.parser.Location;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.misc.Pair;

import java.math.BigDecimal;
import java.util.List;

public class Term {

    @Nullable
    private Location location;

    public static class Constant extends Term {
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

    public static class Application extends Term {
        @NotNull
        private List<Term> arguments;

        public Application(@NotNull List<Term> arguments) {
            this.arguments = arguments;
        }
    }

    public static abstract class Lambda extends Term {
        @NotNull
        private List<Pair<String, Type>> arguments;
        @NotNull
        private Term body;

        public Lambda(@NotNull List<Pair<String, Type>> arguments, @NotNull Term body) {
            this.arguments = arguments;
            this.body = body;
        }

        public static class Implicit extends Lambda {
            public Implicit(@NotNull List<Pair<String, Type>> arguments, @NotNull Term body) {
                super(arguments, body);
            }
        }

        public static class Explicit extends Lambda {
            public Explicit(@NotNull List<Pair<String, Type>> arguments, @NotNull Term body) {
                super(arguments, body);
            }

            private int[] variables;
        }
    }

    public static class Variable extends Term {
        @NotNull
        private String name;

        public Variable(@NotNull String name) {
            this.name = name;
        }
    }
}
