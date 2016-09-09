package k.frolov;

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
        Expression result;
        result = ParseLogical();
        return result;
    }

    private Expression ParseLogical(){
        Expression result;
        result = ParseRelation();
        while(true) {
            Logical.OpCode oprt = ParseLogicalOp();
            if(oprt != Logical.OpCode.none){
                Expression right = ParseRelation();
                result = new Logical(result, oprt, right);
                continue;
            }
            else {
                break;
            }
        }
        return result;
    }

    private Expression ParseRelation(){
        Expression result;
        result = ParseTerm();
        while(true) {
            Relation.OpCode oprt = ParseRelOp();
            if(oprt != Relation.OpCode.none){
                Expression right = ParseTerm();
                result = new Relation(result, oprt, right);
            }
            else {
                break;
            }
        }
        return result;
    }

    private Expression ParseTerm(){
        Expression result;
        result = ParseFactor();
        while(true) {
            Term.OpCode oprt = ParseTermOp();
            if(oprt != Term.OpCode.none){
                Expression right = ParseFactor();
                result = new Term(result, oprt, right);
                continue;
            }
            else {
                break;
            }
        }
        return result;
    }

    private Expression ParseFactor(){
        Expression result;
        result = ParsePrimary();
        while(true) {
            Factor.OpCode oprt = ParseFacOp();
            if(oprt != Factor.OpCode.none){
                Expression right = ParsePrimary();
                result = new Factor(result, oprt, right);
                continue;
            }
            else {
                break;
            }
        }


        return result;
    }

    private Expression ParsePrimary(){
        Expression result = null;
        if ( Character.isDigit(seeNextChar()) )
            result = ParseInteger();
        else if ( seeNextChar() == '(' ) {
            nextChar();
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

    public Character nextChar(){
        try {
            Character bfrChar = input.charAt(0);
            input = input.substring(1);
            return bfrChar;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public Character seeNextChar(){
        try {
            return input.charAt(0);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public Character seeFollowingChar(){
        try {
            return input.charAt(1);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void skipNextChar(){
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

    private Term.OpCode ParseTermOp(){
        if(seeNextChar() != null) {
            if (seeNextChar() == '-') {
                nextChar();
                return Term.OpCode.sub;
            } else if (seeNextChar() == '+') {
                nextChar();
                return Term.OpCode.add;
            }
            else
                return Term.OpCode.none;
        }
        else
            return Term.OpCode.none;

    }

    private Relation.OpCode ParseRelOp(){
        if(seeNextChar() != null) {
            if (seeNextChar() == '<') {
                nextChar();
                if (seeNextChar() == '=') {
                    nextChar();
                    return Relation.OpCode.lessREq;
                }
                else{
                    return Relation.OpCode.less;
                }
            } else if (seeNextChar() == '>') {
                nextChar();
                if (seeNextChar() == '=') {
                    nextChar();
                    return Relation.OpCode.grtrREq;
                } else {
                    return Relation.OpCode.grtr;
                }
            } else if(seeNextChar() == '!') {
                if (seeFollowingChar() == '=') {
                    nextChar();
                    nextChar();
                    return Relation.OpCode.notEq;
                }
                else
                    return Relation.OpCode.none;
            }
            else if(seeNextChar() == '='){
                nextChar();
                return Relation.OpCode.eq;
            }
            else
                return Relation.OpCode.none;
        }
        else
            return Relation.OpCode.none;

    }

    private Logical.OpCode ParseLogicalOp(){
        if(seeNextChar() != null) {
            if (seeNextChar() == 'a') {
                nextChar();
                nextChar();
                nextChar();
                return Logical.OpCode.and;
            } else if (seeNextChar() == 'o') {
                nextChar();
                nextChar();
                return Logical.OpCode.or;
            } else if(seeNextChar() == 'x') {
                nextChar();
                nextChar();
                nextChar();
                return Logical.OpCode.xor;
            }
            else
                return Logical.OpCode.none;
        }
        else
            return Logical.OpCode.none;

    }
}
