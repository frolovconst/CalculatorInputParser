package k.frolov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter string to calculate");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Parser testParser = new Parser(input);
        Expression expressionTree = testParser.Parse();
        long result = expressionTree.Calculate();
        System.out.println(result);

//        Character bfrChar = testParser.nextChar();
//        while(bfrChar != null) {
//            System.out.println(bfrChar);
//            bfrChar = testParser.nextChar();
//        }
    }
}
