package Queue.Array;

import java.util.Scanner;
import java.util.Stack;
public class Exercise1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<Integer>();
        Queue<Integer> result = new Queue<Integer>();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int value = n;
        boolean checked = false;
        System.out.println("In kết quả: ");
        for (int i = 0; i < n; i++) {
            if (value == arr[i]) {
                result.enqueue(arr[i]);
                value--;
                checked = true;
            } else {            // Thêm phần tử không thoả mãn vào queue
                queue.enqueue(arr[i]);
            }

            // Duyệt lại trong queue kiểm tra xem còn giá trị nào thoả mãn không
            if (checked) {
                while (checked) {
                    checked = false;
                    while (!queue.isEmpty()) {
                        int temp = queue.peek();
                        if (temp == value) {
                            result.enqueue(temp);
                            value--;
                            checked = true;
                            queue.dequeue();
                            break;
                        } else {
                            stack.push(temp);
                            queue.dequeue();
                        }
                    }

                    //Add lại những giá trị vừa chuyển từ queue sang stack
                    while (!stack.isEmpty()) {
                        int tmp = stack.pop();
                        queue.enqueue(tmp);
                    }

                    if (value < 0) {
                        break;
                    }
                }
            }

            // Hiển thị kết quả
            while (!result.isEmpty()) {
                System.out.print(result.dequeue() + " ");
            }
            if (result.isEmpty()) {
                System.out.println();
            }
        }
    }
}
