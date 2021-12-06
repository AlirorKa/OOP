package main;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator_R {

    private static boolean isNumber(String str) throws NumberFormatException {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double safePop(Stack stack) throws Exception {
        try {
            return stack.pop();
        } catch (NumberFormatException e) {
            throw new Exeption("Stack has not enough elements for operaton.");
        }
    }

    
    public static double calculate(String str) throws Exception {
        String[] strNumbers = str.split(" ");
        Stack<Double> numbers = new Stack<>();

        for (int i = strNumbers.length - 1; i >= 0; i--) {
            if (isNumber(strNumbers[i])) {
                numbers.push(Double.parseDouble(strNumbers[i]));
            } else {
                try {
                    NumberOperations operation = NumberOperationsHelper.getOperation(strNumbers[i]);
                    switch (operation) {
                        case Add -> numbers.push(numbers.safePop() + numbers.safePop());
                        case Subtract -> numbers.push(numbers.safePop() - numbers.safePop());
                        case Divide -> numbers.push(numbers.safePop() / numbers.safePop());
                        case Multiply -> numbers.push(numbers.safePop() * numbers.safePop());
                        case Log -> numbers.push(Math.log(numbers.safePop()));
                        case Sin -> numbers.push(Math.sin(numbers.safePop()));
                        case Cos -> numbers.push(Math.cos(numbers.safePop()));
                        case Pow -> numbers.push(Math.pow(numbers.safePop(), numbers.safePop()));
                        case Sqrt -> numbers.push(Math.sqrt(numbers.safePop()));
                        default -> {
                            System.out.println("My calculator isn't so smart to do this");
                            throw new Exception("Invalid operation");
                        }
                    }
                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
        }

        double answer = numbers.safePop();
        if (numbers.isEmpty()) {
            return answer;
        } else {
            throw new Exception("Invalid number of arguments");
        }
    }
}
