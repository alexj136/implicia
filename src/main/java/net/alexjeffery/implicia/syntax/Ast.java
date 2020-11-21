package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.parser.Location;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

public abstract class Ast {
    @Nullable
    public Location location;
    public <I, O, X extends Throwable> O visit(@NotNull AstVisitor<I, O, X> visitor, @Nullable I input) throws X {
        return visitor.applyTo(this, input);
    }
}
