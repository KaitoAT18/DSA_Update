package Stack.Class;

import java.util.Scanner;
import java.util.Stack;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t;
        t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            System.out.println("Nhập biểu thức trung tố: ");
            String str = input.nextLine();
            str = addSpace(str);
            var result = infixToPostfix(str);
            System.out.print("Biểu thức hậu tố: " + result);
            System.out.println();
            t--;
        }
    }

    private static String infixToPostfix(String str) {
        Stack<String> stack = new Stack<>();
        String[] infixElements = str.split("\\s+");
        StringBuilder postfix = new StringBuilder();

        for (var e: infixElements) {
            if (precedence(e) > 0) {
                if (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(e);
            } else if (e.equals(")")) {
                var operator = stack.pop();
                while (!operator.equals("(")) {
                    postfix.append(operator).append(" ");
                    operator = stack.pop();
                }
            } else if (e.equals("(")){
                stack.push(e);
            } else {
                postfix.append(e).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            var operator = stack.pop();
            if (!operator.equals("(")) {
                postfix.append(operator).append(" ");
            }
        }
        return postfix.toString();
    }

    private static String addSpace(String str) {
        str = str.replaceAll("\\^", " ^ ");
        str = str.replaceAll("\\*", " * ");
        str = str.replaceAll("\\/", " / ");
        str = str.replaceAll("\\+", " + ");
        str = str.replaceAll("\\-", " - ");
        str = str.replaceAll("\\(", " ( ");
        str = str.replaceAll("\\)", " ) ");
        return str;
    }

    private static int precedence(String input) {
        return switch (input) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }
}
