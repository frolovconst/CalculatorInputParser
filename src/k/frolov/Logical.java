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

    @Override
    public long Calculate() {
        long right = rightPrmr.Calculate();
        long left = leftPrmr.Calculate();
        switch (oprt) {
            case and:
                return left & right;
            case or:
                return left | right;
            case xor:
                return left ^ right;
            case none:
                return 0;
            default:
                return 0;
        }
    }

    @Override public String ToJSON(){
        switch (oprt) {
            case and:
                return "\r\n{ and : {\r\nleft : " + leftPrmr.ToJSON() + "\r\nright : " + rightPrmr.ToJSON() + "\r\n}\r\n}";
            case or:
                return "\r\n{ or : {\r\nleft : " + leftPrmr.ToJSON() + "\r\nright : " + rightPrmr.ToJSON() + "\r\n}\r\n}";
            case xor:
                return "\r\n{ xor : {\r\nleft : " + leftPrmr.ToJSON() + "\r\nright : " + rightPrmr.ToJSON() + "\r\n}\r\n}";
            case none:
                return "";
            default:
                return "";
        }
    }


}
