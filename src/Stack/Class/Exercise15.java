package Stack.Class;

import java.util.Scanner;
import java.util.Stack;

public class Exercise15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số testcase: ");
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            System.out.println("Nhập biểu thức hậu tố cần tính: ");
            String postfix = input.nextLine();
            postfix = addSpace(postfix);
            var result = calculatorPostfix(postfix);
            System.out.println("Kết quả = " + result);
            t--;
        }
    }

    private static double calculatorPostfix(String postfix) {
        Stack<String> stack = new Stack<>();
        String[] postfixElements = postfix.split("\\s+");
        double result;

        for (var e: postfixElements) {
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
