package Stack.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            var result = postfixToPrefix(str);
            System.out.println(result);
            t--;
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

    private static String postfixToPrefix(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder reverse = new StringBuilder(str);
        String revPostfix = reverse.reverse().toString();
        String[] revPostfixElements = revPostfix.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (var e: revPostfixElements) {
            if (precedence(e) > 0) {
                if (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(e);
            } else if (e.equals(")")) {
                var operator = stack.pop();
                while (operator != null && operator.equals("(")) {
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
            if (!operator.equals("(")) {
                result.append(operator).append(" ");
            }
        }
        String prefix = result.reverse().toString();
        return prefix;
    }
}
