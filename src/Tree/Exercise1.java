package Tree;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi kí tự: ");
        String str = input.nextLine();
        var words = str.split("\\s+");

        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        for (var e: words) {
            tree.add(e);
        }
        System.out.println("Các từ sau khi sắp xếp: ");
        tree.inOrder();
    }
}
