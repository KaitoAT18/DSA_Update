package Stack.LinkedList;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t > 0) {
            String str = input.nextLine();
            str = addSpace(str);
            var result = calculatorResult(str);
            System.out.println(result);
            t--;
        }
    }
    private static double calculatorResult(String str) {
        Stack<String> stack = new Stack<>();
        double result;
        String[] elements = str.split("\\s+");

        for (var e: elements) {
            if (isOperator(e)) {
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                result = makeResult(a,b,e);
                stack.push(result + "");
            } else {
                stack.push(e);
            }
        }
        return Double.parseDouble(stack.peek());
    }

    private static String addSpace(String str) {
        str = str.replaceAll("\\^", " ^ ");
        str = str.replaceAll("\\*", " * ");
        str = str.replaceAll("\\/", " / ");
        str = str.replaceAll("\\+", " + ");
        str = str.replaceAll("\\-", " - ");
        return str;
    }

    private static double makeResult(double a, double b, String operator) {
        return switch (operator) {
            case "^" -> Math.pow(a,b);
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> 0;
        };
    }

    private static boolean isOperator(String input) {
        return input.equals("^") || input.equals("*") || input.equals("/") || input.equals("+") || input.equals("-");
    }
}
