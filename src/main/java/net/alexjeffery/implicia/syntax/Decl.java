package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

public class Decl extends Ast {
    public static class Alias extends Decl {
        @NotNull
        public String ident;
        @NotNull
        public Type type;
        public Alias(@NotNull String ident, @NotNull Type type) {
            this.ident = ident;
            this.type = type;
        }
    }
    public static class Function extends Decl {
        @NotNull
        public String name;
        @NotNull
        public List<Pair<String, Type>> args;
        @NotNull
        public Type returnType;
        @NotNull
        public Expr body;
        public Function(@NotNull String name, @NotNull List<Pair<String, Type>> args, @NotNull Type returnType, @NotNull Expr body) {
            this.name = name;
            this.args = args;
            this.returnType = returnType;
            this.body = body;
        }
    }
}
