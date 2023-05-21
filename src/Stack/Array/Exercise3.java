package Stack.Array;

import java.util.Scanner;

public class Exercise3 {
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

    /**
     * Phương thức kiểm tra độ ưu tiên của toán tử
     *
     * @param operator toán tử cần lấy thứ tự ưu tiên
     * @return thứ tự ưu tiên của toán tử
     */
    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case  "^" -> 3;
            default -> 0;
        };
    }

    /**
     * Phương thức thêm dấu cách vào trước và sau các dấu ngoặc, phép toán
     * Mục đích làm cho các phép toán dễ dàng phân tách thành các phân tử đơn
     *
     * @param input biểu thức trung tố đầu vào
     * @return biểu thức trung tố sau khi đã được thêm dấu cách
     */
    private static String addSpace(String input) {
        input = input.replaceAll("\\^", " ^ ");
        input = input.replaceAll("\\(", " ( ");
        input = input.replaceAll("\\)", " ) ");
        input = input.replaceAll("\\+", " + ");
        input = input.replaceAll("-", " - ");
        input = input.replaceAll("\\*", " * ");
        input = input.replaceAll("/", " / ");
        return input;
    }

    /**
     * Phương thức chuyển đổi từ trung tố sang hậu tố
     *
     * @param str chuỗi chứa biểu thức trung tố
     * @return biểu thức hậu tố tương ứng
     */
    private static String infixToPostfix(String str) {
        var infixElements = str.split("\\s+");
        var result = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        for (var e: infixElements) {
            if (precedence(e) > 0) {        // e là toán tử
                while (!stack.isEmpty() && precedence(e) <= precedence(stack.peek())) {
                    result.append(stack.peek()).append(" ");
                    stack.pop();
                }
                stack.push(e);
            } else if (e.equals(")")) {     // dấu ngoặc đóng
                var operator = stack.peek();
                stack.pop();
                while (!operator.equals("(")) {
                    result.append(operator).append(" ");
                    operator = stack.peek();
                    stack.pop();
                }
            } else if (e.equals("(")) {     // dấu ngoặc mở
                stack.push(e);
            } else {                        // toán hạng
                result.append(e).append(" ");
            }
        }
        while (!stack.isEmpty()) {          // pop các phần tử còn lại của stack
            var operator = stack.peek();
            stack.pop();
            if (!operator.equals("(")) {
                result.append(operator).append(" ");
            }
        }
        return result.toString();
    }
}
