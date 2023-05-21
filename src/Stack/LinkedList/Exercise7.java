package Stack.LinkedList;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        int test = input.nextInt();
        input.nextLine();
        while (test > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            var postfix = infixToPostfix(str);
            System.out.println(postfix);
            test--;
        }
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("\\/", " / ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("\\-", " - ");
        input = input.replaceAll("\\(", " ( ");
        input = input.replaceAll("\\)", " ) ");
        return input;
    }

    private static String infixToPostfix(String str) {
        String[] infixElements = str.split("\\s+");
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (var e: infixElements) {
            if (precedence(e) > 0) {
                if (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(e);
            } else if (e.equals(")")) {
                var operator = stack.pop();
                while (!operator.equals("(")) {
                    result.append(operator).append(" ");
                    operator = stack.pop();
                }
            } else if (e.equals("(")) {
                stack.push(e);
            } else {
                result.append(e).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            var operator = stack.pop();
            // Truong hop phan tu cuoi la dau "("
            if (!operator.equals("(")) {
                result.append(operator).append(" ");
            }
        }
        return result.toString();
    }
}
