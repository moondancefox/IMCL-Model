grammar IMCL;

// 结构化、事件触发语言。

//@lexer::header
//{
//    package per.juli.parser;
//}
//
//@parser::header
//{
//    package per.juli.parser;
//}

// 语法文件：
//   * ：修饰前面的字符，0 到多
//   + ：修饰前面的字符，1 到多
//   ? ：修饰前面的字符，1 或 0 个

// lexer rules:

ID  : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9')* ;

VALUE : [-]?([0-9]+[.])?[0-9]+ ;

BOOLEAN : 'TRUE' | 'FALSE';

STRING : '\'' (~('\'') )* '\'';

CALC : '+' | '-' | '*' | '/' | '%';

RELATION :  '>' | '<' | '<=' | '>=' | '==' | '!=';

INVOKE : '<<' | '>>';

WS : [ \t\r\n]* -> skip;


// parser rules

languageIMCL
    : (codeBody)*
    ;

// codeBody
codeBody
    : processDefine
    | resourceDefine
    | constraintDefine

    ;


resourceDefine
    : ('SENSOR'|'DEVICE') ':' varAtom (',' varAtom)* ';'
    ;

processDefine
    : ('program'|'function') ':' ID '(' varDefine?  ')' '[' varDefine ? ']'
      '{' codeBlock*'}'
    ;

// codeBlock
codeBlock
    : assignDefine
    | ifDefine
    | whileDefine
    | triggerDefine
    | channelDefine
    ;

channelDefine
    : channel ';';

/** subDefine */
// trigger
triggerDefine
    : 'TRIGGER' '('conditionExpr')' '{'codeBlock+ '}'
    ;

// whileExpr
whileDefine
    : 'WHILE' '('conditionExpr')' '{'codeBlock+ '}'
    ;

// ifExpr
ifDefine
    : 'IF' '('conditionExpr ')' '{'codeBlock*'}' (elsifDefine)*  elseDefine*
    ;
elsifDefine
    : 'ELSIF' '('conditionExpr ')' '{'codeBlock*'}'
    ;
elseDefine
    : 'ELSE''{'codeBlock*'}'
    ;

assignDefine        // 普通命令的3种代码：1、赋值； 2、函数返回； 3、设备控制（变量或常量 << >> 设备）； 4、return表达； 5、停止
    : varAtom ':=' conditionExpr ';'                                            # assignVariable
    | (varAtom (',' varAtom)*  ':=')? functionExpr ';'                         # assignFunction
    | (varAtom|valueAtom) INVOKE (varAtom|valueAtom)';'                         # assignInvoke      // TODO：改善成多输入／输出
    | 'RETURN' ':' (varAtom | valueAtom) (',' (varAtom | valueAtom))* ';'     # assignReturn
    | 'STOP' ';'                                                               # assignStop
    ;

/** subExpr */
conditionExpr       //  二元操作
    : (varAtom | valueAtom )( op=(CALC|RELATION) (varAtom| valueAtom) )*
    | channel
    ;

varDefine
    : ('PARAM' | 'VAR') ':' varAtom (',' varAtom)*
    ;

functionExpr
    : ID '(' (( valueAtom|varAtom) (',' (valueAtom | varAtom) )*   )?   ')'
    ;

varAtom
    : ID
    ;

valueAtom
    : VALUE
    | BOOLEAN
    | STRING
    ;

// Channel
channel
    : 'CHANNEL.DD.' ('!'|'?') (ID|VALUE)  ':' varAtom (';')?
    | 'CHANNEL.CD.' ('!'|'?') (ID|VALUE) (';')?
    | 'DATA.SYNC.' ID ':'  varAtom (';')?
    ;


// resources constraint
constraintDefine
    : 'constraint' ':' varAtom '{' varAtom (',' varAtom)* '}' ';'
    ;

