package Stack.LinkedList;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập chuỗi cần đảo ngược: ");
        String str = input.nextLine();
        String[] revStr = str.split("\\s+");

        for (var e: revStr) {
            stringStack.push(e);
        }
        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
    }
}
