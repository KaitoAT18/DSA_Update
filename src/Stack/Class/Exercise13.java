package Stack.Class;

import java.util.Scanner;
import java.util.Stack;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        System.out.println("Nhập chuỗi: ");
        String str = input.nextLine();
        String[] arrStr = str.split("\\s+");

        for (var e: arrStr) {
            stack.push(e);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() +  " ");
        }
    }
}
