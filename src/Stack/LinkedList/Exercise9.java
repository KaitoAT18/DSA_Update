package Stack.LinkedList;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            String str = input.nextLine();
            str = addSpace(str);
            var result = postfixToInfix(str);
            System.out.println(result);
            t--;
        }
    }

    private static boolean isOperator(String operator) {
        return operator.equals("^") || operator.equals("*") || operator.equals("/") || operator.equals("+") || operator.equals("-");
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

    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("\\/", " / ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("\\-", " - ");
        return input;
    }

    private static String add(String str) {
        return "(" + str + ")";
    }

    private static String postfixToInfix(String str) {
        Stack<String> stack = new Stack<>();
        String infix;
        String[] postfixElements = str.split("\\s+");

        for (var e: postfixElements) {
            if (isOperator(e)) {
                String b = stack.pop();
                String a = stack.pop();
                infix = makeExpression(a,b,e);
                if (!stack.isEmpty()) {
                    infix = add(infix);
                } else if (stack.isEmpty() && (infix.contains("(") && infix.contains(")"))) {
                    infix = add(infix);
                }
                stack.push(infix);
            } else {
                stack.push(e);
            }
        }
        return stack.peek();
    }
}
