package main;

import java.util.Objects;
import java.util.Scanner;

public class Scanner_str {
    public static void scanner_string(String[] args) throws Exception  {
        Scanner in = new Scanner(System.in);
        String variables, typeOFNumbers;

        System.out.println("My calculator supports such operation: + - * / log() pow() sqrt() sin() cos()\n" +
                "Which type of numbers do you want to work with(type R/C)");
        typeOFNumbers = in.nextLine();

        if (typeOFNumbers.equals("С"))
        System.out.println("The example of complex numbers:" + "(+/-)a (+/-)bi");

        while (!(Objects.equals(variables = in.nextLine(), "quit"))){
            try{
                switch (variables){
                    case "R" -> System.out.println(Calculator_R.calculate(variables));
                    case "C" -> System.out.println(Calculator_C.calculate(variables));
                    default -> throw new Exception("No such type");
                }
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        in.close();
    }
}
