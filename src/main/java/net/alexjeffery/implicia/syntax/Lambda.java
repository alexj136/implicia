package net.alexjeffery.implicia.syntax;

public abstract class Lambda extends Term {
    private Type type;
    private Term body;
    public static class Implicit extends Lambda { }
    public static class Explicit extends Lambda {
        private int[] variables;
    }
}
