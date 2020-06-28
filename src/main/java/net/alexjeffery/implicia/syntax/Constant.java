package net.alexjeffery.implicia.syntax;

import java.math.BigDecimal;

public class Constant extends Term {
    public static class Int extends Constant {
        private int value;
    }
    public static class Char extends Constant {
        private char value;
    }
    public static class Numeric extends Constant {
        private BigDecimal value;
    }
    public static class List extends Constant { }
    public static class Concat extends Constant { }
    public static class Append extends Constant { }
    public static class Add extends Constant { }
    public static class Sub extends Constant { }
}
