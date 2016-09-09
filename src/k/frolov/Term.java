package k.frolov;

/**
 * Created by Carioca on 09/09/16.
 */
public class Term extends Expression{
    enum OpCode {add, sub, none};
    private Expression leftPrmr, rightPrmr;
    private OpCode oprt;

    public Term(Expression leftPrmr, OpCode oprt, Expression rightPrmr){
        this.leftPrmr = leftPrmr;
        this.oprt = oprt;
        this.rightPrmr = rightPrmr;
    }

//    private OpCode ParseTerOp(){
//        if(Parser.seeNextChar() != null) {
//            if (Parser.seeNextChar() == '-') {
//                Parser.nextChar();
//                return OpCode.sub;
//            } else if (Parser.seeNextChar() == '+') {
//                Parser.nextChar();
//                return OpCode.add;
//            }
//            else
//                return Term.OpCode.none;
//        }
//        else
//            return OpCode.none;
//
//    }
}
