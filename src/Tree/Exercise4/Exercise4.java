package Tree.Exercise4;



import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        Scanner input = new Scanner(System.in);

        createData(tree);
        int choice = 0;
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Liệt kê các từ theo thứ tự từ điển a-z.");
            System.out.println("2. Tìm tất cả các từ có số lần xuất hiện nhiều nhất trong chuỗi.");
            System.out.println("3. Tìm tất cả các từ có số lần xuất hiện ít nhất.");
            System.out.println("4. Tìm tất cả các từ có số lần xuất hiện bằng k, với 0 < k.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");

            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Danh sách cây theo thứ tự từ a-z: ");
                    tree.inOrder();
                    break;
                }
                case 2: {
                    System.out.println("Các node có số lần xuất hiện nhiều nhất trong cây: ");
                    tree.showMaxOccurence();
                    break;
                }
                case 3: {
                    System.out.println("Các node có số lần xuất hiện ít nhất trong cây: ");
                    tree.showMinOccurence();
                    break;
                }
                case 4: {
                    System.out.println("Nhập số lần xuất hiện cần tìm: ");
                    int occ = input.nextInt();
                    System.out.printf("Các node có số lần xuất hiện bằng [%d]:\n", occ);
                    tree.showNode(occ);
                    System.out.println();
                    break;
                }
                case 0: {
                    System.out.println("Bye.");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng.");
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void createData(BinarySearchTree<String> tree) {
        tree.add("Minh");
        tree.add("Long");
        tree.add("Khánh");
        tree.add("Bảo");
        tree.add("Bảo");
        tree.add("Chiều");
        tree.add("Phong");
        tree.add("Ngọc");
        tree.add("Ngọc");
        tree.add("Ngọc");
        tree.add("Phong");
        tree.add("Minh");
        tree.add("Anh");
        tree.add("Sang");
        tree.add("Phong");
        tree.add("Tuấn");
        tree.add("Nam");
        tree.add("Nam");
        tree.add("Thảo");
        tree.add("Tùng");
        tree.add("Tùng");
        tree.add("Minh");
        tree.add("Phong");
    }
}
