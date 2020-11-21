package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;

public abstract class Type extends Term {
    public static class Function extends Type {
        @NotNull
        private List<Type> argumentTypes;
        @NotNull
        private Type returnType;
        public Function(@NotNull List<Type> argumentTypes, @NotNull Type returnType) {
            this.argumentTypes = argumentTypes;
            this.returnType = returnType;
        }
    }
    public static class Int extends Type {
        private Int() { }
        public static final Int INSTANCE = new Int();
    }
    public static class Char extends Type {
        private Char() { }
        public static final Char INSTANCE = new Char();
    }
    public static class Numeric extends Type {
        private Numeric() { }
        public static final Numeric INSTANCE = new Numeric();
    }
    public static class ListT extends Type {
        private Type argument;
    }
}
