package net.alexjeffery.implicia.parser;

import org.antlr.v4.runtime.misc.Nullable;

public class Location {

    @Nullable
    private final String fileName;

    private final int lineNumber;
    private final int columnNumber;

    public String getFileName() {
        return fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public Location(@Nullable String fileName, int lineNumber, int columnNumber) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }
}
