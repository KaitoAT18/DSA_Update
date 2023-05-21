package Tree;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class Exercise2 {
    public static void main(String[] args) {
        MyBST<Integer> tree = new MyBST<>();

        // Add elements to tree
        tree.add(10);
        tree.add(1);
        tree.add(21);
        tree.add(8);
        tree.add(3);
        tree.add(6);
        tree.add(9);
        tree.add(0);
        tree.add(11);
        tree.add(36);

        System.out.println("Tree sắp xếp theo thứ tự tăng dần giá trị: ");
        tree.ascending();
        System.out.println("\nTree sắp xếp theo thứ tự giảm dần giá trị: ");
        tree.descending();
        System.out.println("\nTree sắp xếp theo thứ tự LRN: ");
        tree.LRN();
        System.out.println("\nTree sắp xếp theo thứ tự RLN: ");
        tree.RLN();
        System.out.println("\nTree sắp xếp theo thứ tự NLR: ");
        tree.NLR();
        System.out.println("\nTree sắp xếp theo thứ tự NRL: ");
        tree.NRL();
    }
}
