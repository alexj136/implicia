package net.alexjeffery.implicia.syntax;

public abstract class Type extends Term {
    public static class Function extends Type {
        private Type[] arguments;
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
    public static class List extends Type {
        private Type argument;
    }
}
