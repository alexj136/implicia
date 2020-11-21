grammar Implicia;

@parser::header {
    import net.alexjeffery.implicia.syntax.Term;
    import net.alexjeffery.implicia.syntax.Type;
}

implicia : term ;

term returns [Term out]
    : TkFunction args TkLCurly term TkRCurly { $out = new Term.Lambda.Explicit($args.out, $term.out); }
    | TkId TkLPar terms TkRPar { $out = new Term.Application($terms.out); }
    | TkId { $out = new Term.Variable($TkId.text); }
    | constant { $out = $constant.out; }
    ;

args returns [List<Pair<String, Type>> out]
    : TkId ':' type ',' args { $out = $args.out; $out.add(new Pair($TkId.text, $type.out)); }
    | TkId ':' type { $out = new ArrayList<>(); $out.add(new Pair($TkId.text, $type.out)); }
    ;

terms returns [List<Term> out]
    : term ',' terms { $terms.out.add(0, $term.out); $out = $terms.out; }
    | term { $out = new ArrayList<Term>(); $out.add($term.out); }
    ;

constant returns [Term out]
    : TkNumber { $out = new Term.Constant.Int(Integer.parseInt($TkNumber.text)); }
    | TkPlus { $out = new Term.Constant.Add(); }
    ;

type returns [Type out]
    : TkInt { $out = Type.Int.INSTANCE; }
    | TkNumeric { $out = Type.Numeric.INSTANCE; }
    | TkLPar types TkRPar type { $out = new Type.Function($types.out, $type.out); }
    ;

types returns [List<Type> out]
    : type ',' types { $types.out.add(0, $type.out); $out = $types.out; }
    | type { $out = new ArrayList<Type>(); $out.add($type.out); }
    ;

// Lexer rules must start with a capital letter.
TkPlus : 'plus' ;
TkInt : 'int' ;
TkNumeric : 'numeric' ;
TkFunction : 'function' ;
TkLPar : '(' ;
TkRPar : ')' ;
TkLCurly : '{' ;
TkRCurly : '}' ;
TkId : ('a'..'z')+ ;
TkNumber : ('0'..'9') + ('.' ('0'..'9') +)? ;
Whitespace : [ \t\r\n]+ -> skip ;