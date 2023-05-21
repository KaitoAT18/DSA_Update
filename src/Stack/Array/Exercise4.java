package Stack.Array;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t > 0) {
            var str = input.nextLine();
            str = addSpace(str);
            var result = calculatorResult(str);
            System.out.println(result);
            t--;
        }
    }

    /**
     * Phương thức kiểm tra toán tử
     *
     * @param input chuỗi đầu vào cần kiểm tra
     * @return kết quả kiểm tra
     */
    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("^");
    }

    /**
     * Phương thức tính kết quả a operator b
     *
     * @param a toán hạng đầu
     * @param b toán hạng sau
     * @param e toán tử
     * @return kết quả a e b
     */
    private static double makeResult(double a, double b, String e) {
        return switch (e) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "^" -> Math.pow(a,b);
            default -> 0;
        };
    }

    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("-", " - ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("/", " / ");
        return input;
    }

    /**
     *Phương thức tính chuỗi hậu tố
     *
     * @param str chuỗi hậu tố truyền vào
     * @return kết quả tính được
     */
    private static double calculatorResult(String str) {
        double result;
        Stack<String> stack = new Stack<>(String.class);
        String[] words = str.split("\\s+");

        for (var e: words) {
            if (isOperator(e)) {
                double b = Double.parseDouble(stack.peek());
                stack.pop();
                double a = Double.parseDouble(stack.peek());
                stack.pop();
                result = makeResult(a, b, e);
                stack.push(result + "");
            } else {
                stack.push(e);
            }
        }
        return Double.parseDouble(stack.peek());
    }
}
