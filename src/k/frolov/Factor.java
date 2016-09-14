package k.frolov;

/**
 * Created by Konstantin on 07.09.2016.
 */
public class Factor extends Expression {
    enum OpCode {mult, div, none};
    private Expression leftPrmr, rightPrmr;
    private OpCode oprt;

    public Factor(Expression leftPrmr, OpCode oprt, Expression rightPrmr){
        this.leftPrmr = leftPrmr;
        this.oprt = oprt;
        this.rightPrmr = rightPrmr;
    }

    @Override
    public long Calculate() {
        long right = rightPrmr.Calculate();
        long left = leftPrmr.Calculate();
        switch (oprt) {
            case mult:
                return left * right;
            case div:
                return left / right;
            case none:
                return 0;
            default: {
                return 0;
            }
        }
    }

    @Override public String ToJSON(){
        switch (oprt) {
            case mult:
                return "\r\n{ * : {\r\nleft : " + leftPrmr.ToJSON() + "\r\nright : " + rightPrmr.ToJSON() + "\r\n}\r\n}";
            case div:
                return "\r\n{ / : {\r\nleft : " + leftPrmr.ToJSON() + "\r\nright : " + rightPrmr.ToJSON() + "\r\n}\r\n}";
            case none:
                return "";
            default:
                return "";
        }    }


}
