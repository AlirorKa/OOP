package main;

import java.util.ArrayList;
import java.util.Stack;
import java.lang.Math.*;

final public class Calculator_C {
        public static double[] calculate (String str) throws Exception {
            String[] strNumbers = str.split(" ");
            Stack<Double> realNumbers = new Stack<>();
            Stack<Double> imgNumbers = new Stack<>();

            for (int i = strNumbers.length - 1; i >= 0; i--) {
                if (strNumbers[i].contains("i")) {
                    try{
                        if (strNumbers[i].charAt(0) == '+') {
                            strNumbers[i] = strNumbers[i].substring(1, strNumbers.length - 1);
                            imgNumbers.push(Double.parseDouble(strNumbers[i]));
                        } else {
                            strNumbers[i] = strNumbers[i].substring(0, strNumbers.length - 1);
                            imgNumbers.push(Double.parseDouble(strNumbers[i]));
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("I can't read such format :(");
                        throw new Exception("Invalid format");
                    }

                } else {
                    try {
                        realNumbers.push(Double.parseDouble(strNumbers[i]));
                    }
                    catch (NumberFormatException e) {
                        double a, b, c, d;

                        switch (strNumbers[i]) {
                            case "+" -> {
                                realNumbers.push(realNumbers.pop() + realNumbers.pop());
                                imgNumbers.push(imgNumbers.pop() + imgNumbers.pop());
                            }
                            case "-" -> {
                                realNumbers.push(realNumbers.pop() - realNumbers.pop());
                                imgNumbers.push(imgNumbers.pop() - imgNumbers.pop());
                            }
                            case "*" -> {
                                a = realNumbers.pop();
                                c = realNumbers.pop();
                                b = imgNumbers.pop();
                                d = imgNumbers.pop();

                                realNumbers.push((a * c) - (b * d));
                                imgNumbers.push((a * d) + (c * b));
                            }
                            case "/" -> {
                                a = realNumbers.pop();
                                c = realNumbers.pop();
                                b = imgNumbers.pop();
                                d = imgNumbers.pop();

                                realNumbers.push((a*c + b*d) / ((Math.pow(c, 2)) + Math.pow(d, 2)));
                                imgNumbers.push((b*c + a*d) / ((Math.pow(c, 2)) + Math.pow(d, 2)));
                            }
                            default -> throw new RuntimeException("Invalid token: " + strNumbers[i]);
                        }
                    }
                }
            }


            double answer[] = new double[0];
            answer[0] = realNumbers.pop();
            answer[1]  = imgNumbers.pop();

            if (realNumbers.isEmpty() && imgNumbers.isEmpty()) {
                return answer;
            } else {
                throw new Exception("Invalid number of arguments");
            }
        }
}


