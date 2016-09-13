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

    @Override
    public long Calculate() {
        long right = rightPrmr.Calculate();
        long left = leftPrmr.Calculate();
        switch (oprt) {
            case less:
                if(left < right)
                    return 1;
                else return 0;
            case lessREq:
                if(left <= right)
                    return 1;
                else return 0;
            case grtr:
                if(left > right)
                    return 1;
                else return 0;
            case grtrREq:
                if(left >= right)
                    return 1;
                else return 0;
            case eq:
                if(left == right)
                    return 1;
                else return 0;
            case notEq:
                if(left != right)
                    return 1;
                else return 0;
            case none:
                return 0;
            default:
                return 0;
        }
    }

}
