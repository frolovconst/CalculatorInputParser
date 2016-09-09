package k.frolov;

/**
 * Created by Carioca on 09/09/16.
 */
public class Logical extends Expression{
    enum OpCode {and, or, xor, none};
    private Expression leftPrmr, rightPrmr;
    private OpCode oprt;

    public Logical(Expression leftPrmr, OpCode oprt, Expression rightPrmr){
        this.leftPrmr = leftPrmr;
        this.oprt = oprt;
        this.rightPrmr = rightPrmr;
    }


}
