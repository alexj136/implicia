package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

public class Decl extends Ast {
    public static class Alias extends Decl {
        @NotNull
        private String ident;
        @NotNull
        private Type type;
        public Alias(@NotNull String ident, @NotNull Type type) {
            this.ident = ident;
            this.type = type;
        }
    }
    public static class Function extends Decl {
        @NotNull
        private String ident;
        @NotNull
        private List<Pair<String, Type>> args;
        @NotNull
        private Type returnType;
        @NotNull
        private Expr body;
        public Function(@NotNull String ident, @NotNull List<Pair<String, Type>> args, @NotNull Type returnType, @NotNull Expr body) {
            this.ident = ident;
            this.args = args;
            this.returnType = returnType;
            this.body = body;
        }
    }
}
