package k.frolov;

/**
 * Created by Konstantin on 07.09.2016.
 */
public class Relation extends Expression{
    enum OpCode {less, lessREq, grtr, grtrREq, eq, notEq, none};
    private Expression leftPrmr, rightPrmr;
    private OpCode oprt;

    public Relation(Expression leftPrmr, OpCode oprt, Expression rightPrmr){
        this.leftPrmr = leftPrmr;
        this.oprt = oprt;
        this.rightPrmr = rightPrmr;
    }

}
