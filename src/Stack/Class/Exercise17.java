package Stack.Class;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Exercise17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số testcase: ");
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            System.out.println("Nhập biểu thức trung tố: ");
            String infix = input.nextLine();
            infix = addSpace(infix);
            var prefix = infixToPrefix(infix);
            System.out.println("Biểu thức tiền tố: " + prefix);
            t--;
        }
    }

    private static String addSpace(String infix) {
        infix = infix.replaceAll("\\^", " ^ ");
        infix = infix.replaceAll("\\*", " * ");
        infix = infix.replaceAll("\\/", " / ");
        infix = infix.replaceAll("\\+", " + ");
        infix = infix.replaceAll("\\-", " - ");
        infix = infix.replaceAll("\\(", " ( ");
        infix = infix.replaceAll("\\)", " ) ");
        return infix;
    }

    private static int precedence(String input) {
        return switch (input) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    private static String infixToPrefix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder rev = new StringBuilder(infix);
        String revInfix = rev.reverse().toString();
        String[] revInfixElements = revInfix.split("\\s+");
        StringBuilder result = new StringBuilder();
        String prefix;

        for (var e: revInfixElements) {
            if (precedence(e) > 0) {
                if (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(e);
            } else if (e.equals(")")) {
                var operator = "";
                if (!stack.isEmpty()) {
                    operator = stack.pop();
                }
                while (operator != "" && !operator.equals("(")) {
                    result.append(operator).append(" ");
                    try {
                        operator = stack.pop();
                    } catch (EmptyStackException ese) {
                        ese.getMessage();
                    } finally {
                        break;
                    }
                }
            } else if (e.equals("(")){
                stack.push(e);
            } else {
                result.append(e).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            var operator = stack.pop();
            if (!operator.equals("(")) {
                result.append(operator).append(" ");
            }
        }

        prefix = result.reverse().toString();
        return prefix;
    }
}
