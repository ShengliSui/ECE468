grammar Micro;

fragment ANY_LETTER: [A-Za-z];
fragment ANY_DIGIT: [0-9];
fragment COMMENT_BEGIN: '--';

KEYWORD: 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSIF'|'ENDIF'|'DO'|'WHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT'|'TRUE'|'FALSE' ;

IDENTIFIER: (ANY_LETTER)((ANY_LETTER | ANY_DIGIT)+)? ;
INTLITERAL: ANY_DIGIT+ ;
FLOATLITERAL: (ANY_DIGIT*)'.'(ANY_DIGIT+) ;
STRINGLITERAL: '"'(~[\"])*'"' ;                  /* add '\0' if necessary */
COMMENT: COMMENT_BEGIN(~[\n\r])* -> skip;
WHITESPACE: [\n\r\t ]+ -> skip;


OPERATOR: ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=';

dummy	  :;
