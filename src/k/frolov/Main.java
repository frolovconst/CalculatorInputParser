package k.frolov;

import java.io.FileWriter;
import java.io.IOException;
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

        try{
            FileWriter file = new FileWriter("./JSONoutput.json");
            String output = "";
            output = expressionTree.ToJSON().substring(2) ;
            file.write(output);
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

//         Do not use
//        Character bfrChar = testParser.nextChar();
//        while(bfrChar != null) {
//            System.out.println(bfrChar);
//            bfrChar = testParser.nextChar();
//        }
    }
}
