import java.lang.*;

/**
 * Created by Konstantin on 07.09.2016.
 */
public class Parser {
    private String input;

    public Parser (String input){
        this.input = input;
    }

    public Expression Parse(){
        return ParseFactor();
    }

    private Expression ParseFactor(){
        Expression result;
        result = ParsePrimary();
        Character bfrChar = seeNextChar();
        while(true) {
            Factor.OpCode oprt = ParseFacOp();
            if(oprt != Factor.OpCode.none){
                Expression right = ParsePrimary();
                result = new Factor((Primary)result, oprt, (Primary)right);
            }
            else {
                break;
            }
        }
//        if(bfrChar == '*' ||  bfrChar == '/' ){
//            result =
//        }


        return result;
    }

    private Expression ParsePrimary(){
        Expression result = null;
        if ( Character.isDigit(seeNextChar()) )
            result = ParseInteger();
        else if ( seeNextChar() == '(' ) {
            result = Parse();
            skipNextChar(); // skip ‘)’
        }
//        else
//        { ... } // error

        return result;
    }

    private myInteger ParseInteger(){
        myInteger result = new myInteger();
        String toBeConvToInt = "";
        long value = 0;
        Character bfrChar = seeNextChar();
        while(true){
            if(bfrChar != null && Character.isDigit(bfrChar)){
                bfrChar = nextChar();
                toBeConvToInt = toBeConvToInt + bfrChar;
                bfrChar = seeNextChar();
            }
            else
                break;
        }

//        while(Character.isDigit(bfrChar)){
//            if(Character.isDigit(bfrChar)) {
//                toBeConvToInt = toBeConvToInt + bfrChar;
//                bfrChar = nextChar();
//            }
//        }
        value = Long.parseLong(toBeConvToInt);
        result.setValue(value);
        return result;
    }

    private Character nextChar(){
        try {
            Character bfrChar = input.charAt(0);
            input = input.substring(1);
            return bfrChar;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    private Character seeNextChar(){
        try {
            return input.charAt(0);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    private void skipNextChar(){
        try {
            input = input.substring(1);
        }
        catch (IndexOutOfBoundsException e){
        }
    }

    private Factor.OpCode ParseFacOp(){
        if(seeNextChar() != null) {
            if (seeNextChar() == '/') {
                nextChar();
                return Factor.OpCode.div;
            } else if (seeNextChar() == '*') {
                nextChar();
                return Factor.OpCode.mult;
            }
            else
                return Factor.OpCode.none;
        }
        else
            return Factor.OpCode.none;

    }
}
