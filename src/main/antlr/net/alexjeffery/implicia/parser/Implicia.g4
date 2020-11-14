grammar Implicia;

implicia : term ;

term
    : TkFunction argsLabel=args TkLCurly termLabel=term TkRCurly #functionTerm
    | idLabel=TkId TkLPar termsLabel=terms TkRPar #applicationTerm
    | idLabel=TkId #variableTerm
    | constantLabel=constant #constantTerm
    ;

args
    : TkId ':' typeLabel=type ',' argsLabel=args #multipleArgs
    | TkId ':' typeLabel=type #singleArgs
    ;

terms
    : termLabel=term ',' termsLabel=terms #multipleTerms
    | termLabel=term #singleTerms
    ;

constant
    : numberLabel=TkNumber #numberConstant
    | TkPlus #plusConstant
    ;

type
    : TkInt #intType
    | TkNumeric #numericType
    | TkLPar typesLabel=types TkRPar typeLabel=type #functionType
    ;

types
    : typeLabel=type ',' typesLabel=types #multipleTypes
    | typeLabel=type #singleTypes
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