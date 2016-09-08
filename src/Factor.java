/**
 * Created by Konstantin on 07.09.2016.
 */
public class Factor extends Expression {
    enum OpCode {mult, div, none};
    private Primary leftPrmr, rightPrmr;
    private OpCode oprt;

    public Factor(Primary leftPrmr, OpCode oprt, Primary rightPrmr){
        this.leftPrmr = leftPrmr;
        this.oprt = oprt;
        this.rightPrmr = rightPrmr;
    }


}
