package Stack.Array;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> stringStack;

        System.out.println("Nhập vào chuỗi cần đảo ngược: ");
        String str = input.nextLine();

        String[] revStr = str.split(" ");
        stringStack = new Stack<String>(String.class, revStr.length+10);
        for (var e: revStr) {
            stringStack.push(e);
        }

        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.peek() + " ");
            stringStack.pop();
        }
    }
}
