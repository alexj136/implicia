grammar implicia;

implicia : term ;

term
    : function args tok_lcurly term tok_rcurly
    | id tok_lpar terms tok_rpar
    | id
    | const
    ;

args
    : id ',' type args
    | id ',' type
    ;

terms
    : term ',' terms
    | term
    ;

const
    : number
    | plus
    ;

type
    : int
    | tok_lpar types tok_rpar type
    ;

types
    : type ',' types
    | type
    ;

plus : 'plus' ;
int : 'int' ;
function : 'function' ;
tok_lpar : '(' ;
tok_rpar : ')' ;
tok_lcurly : '{' ;
tok_rcurly : '}' ;
id : ('a'..'z')+ ;
number : ('0'..'9') + ('.' ('0'..'9') +)? ;
