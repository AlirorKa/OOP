package main;

enum NumberOperations { Add, Subtract, Divide, Multiply, Log, Sin, Cos, Pow, Sqrt, Undefined}

class NumberOperationsHelper  {
    public static NumberOperations getOperation(String strOperation) throws Exception {
        switch (strOperation){
            case "+": return NumberOperations.Add;
            case "-": return NumberOperations.Subtract;
            case "/": return NumberOperations.Divide;
            case "*": return NumberOperations.Multiply;
            case "log": return NumberOperations.Log;
            case "sin": return NumberOperations.Sin;
            case "cos": return NumberOperations.Cos;
            case "pow": return NumberOperations.Pow;
            case "sqrt": return NumberOperations.Sqrt;
            default: throw new Exception("Invalid operation");
        }
    }
}
