grammar Implicia;

@parser::header {
    import net.alexjeffery.implicia.syntax.Decl;
    import net.alexjeffery.implicia.syntax.Expr;
    import net.alexjeffery.implicia.syntax.Type;
}

decls returns [List<Decl> out]
    : decl decls { $out = $decls.out; $out.add(0, $decl.out); }
    | decl { $out = new ArrayList<>(); $out.add($decl.out); }
    ;

decl returns [Decl out]
    : KwAlias Ident '=' type { $out = new Decl.Alias($Ident.text, $type.out); }
    | KwFunction Ident '(' args ')' type '=' expr { $out = new Decl.Function($Ident.text, $args.out, $type.out, $expr.out); }
    ;

expr returns [Expr out]
    : '{' args '->' expr '}' { $out = new Expr.Lambda($args.out, $expr.out); }
    | '{' args '->' expr '}' '(' exprs ')' { $out = new Expr.Apply(new Expr.Lambda($args.out, $expr.out), $exprs.out); }
    | Ident '(' exprs ')' { $out = new Expr.Call($Ident.text, $exprs.out); }
    | Ident { $out = new Expr.Variable($Ident.text); }
    | e1=expr binop e2=expr { $out = new Expr.BinOp($binop.out, $e1.out, $e2.out); }
    | unaryop expr { $out = new Expr.UnaryOp($unaryop.out, $expr.out); }
    | e1=expr '[' e2=expr ']' { $out = new Expr.BinOp(Expr.BinOpType.INDEX, $e1.out, $e2.out); }
    | '[' ']' { $out = new Expr.Constant.ListE(new ArrayList<>(0)); }
    | '[' exprs ']' { $out = new Expr.Constant.ListE($exprs.out); }
    | constant { $out = $constant.out; }
    | '(' expr ')' { $out = $expr.out; }
    ;

args returns [List<Pair<String, Type>> out]
    : Ident ':' type ',' args { $out = $args.out; $out.add(new Pair($Ident.text, $type.out)); }
    | Ident ':' type { $out = new ArrayList<>(); $out.add(new Pair($Ident.text, $type.out)); }
    ;

exprs returns [List<Expr> out]
    : expr ',' exprs { $exprs.out.add(0, $expr.out); $out = $exprs.out; }
    | expr { $out = new ArrayList<Expr>(); $out.add($expr.out); }
    ;

constant returns [Expr out]
    : Number { $out = Expr.Constant.number($Number.text); }
    | KwTrue { $out = new Expr.Constant.Bool(true); }
    | KwFalse { $out = new Expr.Constant.Bool(false); }
    ;

binop returns [Expr.BinOpType out]
    : '+' { $out = Expr.BinOpType.ADD; }
    | '-' { $out = Expr.BinOpType.SUBTRACT; }
    | '*' { $out = Expr.BinOpType.MULTIPLY; }
    | '/' { $out = Expr.BinOpType.DIVIDE; }
    | '%' { $out = Expr.BinOpType.MODULO; }
    | '^' { $out = Expr.BinOpType.POWER; }
    | '<' { $out = Expr.BinOpType.LT; }
    | '>' { $out = Expr.BinOpType.GT; }
    | '<=' { $out = Expr.BinOpType.LE; }
    | '>=' { $out = Expr.BinOpType.GE; }
    | '==' { $out = Expr.BinOpType.EQ; }
    | '!=' { $out = Expr.BinOpType.NE; }
    | '&&' { $out = Expr.BinOpType.AND; }
    | '||' { $out = Expr.BinOpType.OR; }
    | '++' { $out = Expr.BinOpType.CONCAT; }
    ;

unaryop returns [Expr.UnaryOpType out]
    : '!' { $out = Expr.UnaryOpType.NOT; }
    ;

type returns [Type out]
    : KwInt { $out = new Type.Int(); }
    | KwBool { $out = new Type.Bool(); }
    | KwNumeric { $out = new Type.Numeric(); }
    | KwChar { $out = new Type.Char(); }
    | '(' types ')' type { $out = new Type.Function($types.out, $type.out); }
    ;

types returns [List<Type> out]
    : type ',' types { $types.out.add(0, $type.out); $out = $types.out; }
    | type { $out = new ArrayList<Type>(); $out.add($type.out); }
    ;

// Lexer rules must start with a capital letter.
KwInt : 'int' ;
KwBool : 'bool' ;
KwNumeric : 'numeric' ;
KwChar : 'char' ;
KwFunction : 'function' ;
KwAlias : 'alias' ;
KwTrue : 'true' ;
KwFalse : 'false' ;
Ident : ('a'..'z')+ ;
Number : ('0'..'9') + ('.' ('0'..'9') +)? ;
Whitespace : [ \t\r\n]+ -> skip ;