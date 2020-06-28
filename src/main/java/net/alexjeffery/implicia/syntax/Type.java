package net.alexjeffery.implicia.syntax;

public abstract class Type {
    public static class Function extends Type {
        private Type[] arguments;
    }
    public static class Int extends Type { }
    public static class Char extends Type { }
    public static class Numeric extends Type { }
    public static class List extends Type {
        private Type argument;
    }
}
