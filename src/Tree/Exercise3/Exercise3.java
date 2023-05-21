package Tree.Exercise3;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Scanner input = new Scanner(System.in);

        int choice = 4;
        do {
            System.out.println("------------------------------ MENU ------------------------------");
            System.out.println("| 1. Thêm một node vào cây.                                      |");
            System.out.println("| 2. Duyệt cây in-order.                                         |");
            System.out.println("| 3. Nhập giá trị x từ bàn phím, tìm xem x có tồn tại hay không. |");
            System.out.println("| 4. Thoát chương trình.                                         |");
            System.out.println("------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bạn chọn?: ");

            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Nhập dữ liệu cho node cần thêm: ");
                    var newNode = input.nextInt();
                    tree.add(newNode);
                    break;
                }
                case 2: {
                    System.out.println("Danh sách cây theo thứ tự In-Order: ");
                    tree.inOrder();
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Nhập giá trị cần tìm x: ");
                    var x = input.nextInt();
                    if (tree.search(x)) {
                        System.out.println("Tìm thấy giá trị " + x + ".");
                    } else {
                        System.out.println("Không tìm thấy giá trị " + x + ".");
                    }
                    break;
                }
                case 4: {
                    System.out.println(".__________. XIN CHÀO VÀ HẸN GẶP LẠI.__________.");
                    break;
                }
                default: {
                    System.out.println("=> Sai chức năng, vui lòng KIỂM TRA LẠI!");
                    break;
                }
            }
        } while (choice != 4);
    }
}
