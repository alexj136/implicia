package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.syntax.visitor.TypeVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import java.util.List;

public abstract class Type extends Ast {
    public <I, O, X extends Throwable> O visit(@NotNull TypeVisitor<I, O, X> visitor, @Nullable I input) throws X {
        return visitor.applyTo(this, input);
    }
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
    public static class Bool extends Type {
        public Bool() { }
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
    public static class Tuple extends Type {
        @NotNull
        private List<Type> elements;
        public Tuple(@NotNull List<Type> elements) {
            this.elements = elements;
        }
    }
    public static class Sum extends Type {
        @NotNull
        private List<Type> options;
        public Sum(@NotNull List<Type> options) {
            this.options = options;
        }
    }
}
