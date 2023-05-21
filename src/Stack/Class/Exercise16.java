package Stack.Class;

import java.util.Scanner;
import java.util.Stack;

public class Exercise16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số testcase: ");
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            System.out.println("Nhập biểu thức hậu tố cần chuyển: ");
            String postfix = input.nextLine();
            postfix = addSpace(postfix);
            var result = postfixToInfix(postfix);
            System.out.println("Biểu thức trung tố: " + result);
            t--;
        }
    }

    private static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        String[] postfixElements = postfix.split("\\s+");
        String result = new String();

        for (var e: postfixElements) {
            if (isOperator(e)) {
                String b = stack.pop();
                String a = stack.pop();
                result = makeExpression(a,b,e);
                if (!stack.isEmpty()) {
                    result = add(result);
                } else if (stack.isEmpty() && result.contains("(") && result.contains(")")) {
                    result = add(result);
                }
                stack.push(result);
            } else {
                stack.push(e);
            }
        }
        return stack.peek();
    }

    private static String addSpace(String postfix) {
        postfix = postfix.replaceAll("\\^", " ^ ");
        postfix = postfix.replaceAll("\\*", " * ");
        postfix = postfix.replaceAll("\\/", " / ");
        postfix = postfix.replaceAll("\\+", " + ");
        postfix = postfix.replaceAll("\\-", " - ");
        return postfix;
    }

    private static String makeExpression(String a, String b, String operator) {
        return switch (operator) {
            case "^" -> a + " ^ " + b;
            case "*" -> a + " * " + b;
            case "/" -> a + " / " + b;
            case "+" -> a + " + " + b;
            case "-" -> a + " - " + b;
            default -> "";
        };
    }

    private static boolean isOperator(String input) {
        return input.equals("^") || input.equals("*") || input.equals("/") || input.equals("+") || input.equals("-");
    }

    private static String add(String input) {
        return "(" + input + ")";
    }
}
