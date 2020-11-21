package net.alexjeffery.implicia.main;

import net.alexjeffery.implicia.parser.ImpliciaLexer;
import net.alexjeffery.implicia.parser.ImpliciaParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = "src/test/resources/examples/identity.implicia";
        ImpliciaLexer lexer = new ImpliciaLexer(new ANTLRFileStream(inputFileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ImpliciaParser parser = new ImpliciaParser(tokens);
        ParseTree tree = parser.implicia();
    }

}
