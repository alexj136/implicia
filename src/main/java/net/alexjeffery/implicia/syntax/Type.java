package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;

public abstract class Type extends Ast {
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
        public Int() { }
    }
    public static class Char extends Type {
        public Char() { }
    }
    public static class Numeric extends Type {
        public Numeric() { }
    }
    public static class ListT extends Type {
        @NotNull
        private Type argument;
        public ListT(@NotNull Type argument) {
            this.argument = argument;
        }
    }
}
