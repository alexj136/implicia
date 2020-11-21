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
    : Number { $out = new Expr.Constant.Int(Integer.parseInt($Number.text)); }
    | KwPlus { $out = new Expr.Constant.Add(); }
    ;

type returns [Type out]
    : KwInt { $out = new Type.Int(); }
    | KwNumeric { $out = new Type.Numeric(); }
    | '(' types ')' type { $out = new Type.Function($types.out, $type.out); }
    ;

types returns [List<Type> out]
    : type ',' types { $types.out.add(0, $type.out); $out = $types.out; }
    | type { $out = new ArrayList<Type>(); $out.add($type.out); }
    ;

// Lexer rules must start with a capital letter.
KwPlus : 'plus' ;
KwInt : 'int' ;
KwNumeric : 'numeric' ;
KwFunction : 'function' ;
KwAlias : 'alias' ;
Ident : ('a'..'z')+ ;
Number : ('0'..'9') + ('.' ('0'..'9') +)? ;
Whitespace : [ \t\r\n]+ -> skip ;