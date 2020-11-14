grammar implicia;

implicia : term ;

term
    : TkFunction args TkLCurly term TkRCurly
    | TkId TkLPar terms TkRPar
    | TkId
    | constant
    ;

args
    : TkId ',' type args
    | TkId ',' type
    ;

terms
    : term ',' terms
    | term
    ;

constant
    : TkNumber
    | TkPlus
    ;

type
    : TkInt
    | TkLPar types TkRPar type
    ;

types
    : type ',' types
    | type
    ;

// Lexer rules must start with a capital letter.
TkPlus : 'plus' ;
TkInt : 'int' ;
TkFunction : 'function' ;
TkLPar : '(' ;
TkRPar : ')' ;
TkLCurly : '{' ;
TkRCurly : '}' ;
TkId : ('a'..'z')+ ;
TkNumber : ('0'..'9') + ('.' ('0'..'9') +)? ;
