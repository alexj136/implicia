package net.alexjeffery.implicia.syntax;

import net.alexjeffery.implicia.parser.Location;
import org.antlr.v4.runtime.misc.Nullable;

public abstract class Ast {
    @Nullable
    public Location location;
}
