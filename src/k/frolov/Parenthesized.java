package k.frolov;

/**
 * Created by Konstantin on 07.09.2016.
 */
public class Parenthesized extends Primary {
    private Expression expression;

    @Override
    public long Calculate(){
        return expression.Calculate();
    }

    @Override public String ToJSON(){
        return expression.ToJSON();
    }

}
