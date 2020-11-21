package net.alexjeffery.implicia.syntax;

import org.antlr.v4.runtime.misc.NotNull;

public class AstPrinterVisitor implements AstVisitor<Void, Void, RuntimeException> {

    // TODO: get an annotation: @Nonnegative
    private int indent = 0;

    @NotNull
    private StringBuilder builder = new StringBuilder();

    public AstPrinterVisitor() { }

    private void indent() {
        indent++;
    }

    private void unindent() {
        indent--;
    }

    private void unindent(int count) {
        indent -= count;
    }

    private void addLine(String line) {
        for (int i = 0; i < indent; i++) {
            builder.append("    ");
        }
        builder.append(line);
        builder.append("\n");
    }

    public String getAndReset() {
        String out = builder.toString();
        builder = new StringBuilder();
        indent = 0;
        return out;
    }

    public Void applyTo(@NotNull Ast ast, Void input) throws RuntimeException {
        addLine("AST");
        return null;
    }

    public Void applyTo(@NotNull Decl.Alias alias, Void input) throws RuntimeException {
        addLine("ALIAS:");
        indent();
        addLine("NAME: " + alias.ident);
        addLine("TYPE: ");
        indent();
        applyTo(alias.type, null);
        unindent(2);
        return null;
    }

    public Void applyTo(@NotNull Decl.Function function, Void input) throws RuntimeException {
        addLine("FUNCTION:");
        indent();
        addLine("NAME: " + function.name);
        return null;
    }
}
