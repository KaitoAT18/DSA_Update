package LinkedList;

import java.util.Scanner;

public class Exercise4 {
    public static final DoublyLinkedList<Bank> listBankAccount = new DoublyLinkedList<Bank>();
    public static Scanner input = new Scanner(System.in);
    private static void menu() {
        System.out.println("\t\tBANK MANAGEMENT");
        System.out.println("\t1. Thêm mới tài khoản ngân hàng.");
        System.out.println("\t2. Cập nhập số dư cho tài khoản theo số tài khoản. Thông báo trạng thái cập nhập tương ứng.");
        System.out.println("\t3. Hiển thị thông tin các tài khoản hiện có.");
        System.out.println("\t4. Thoát chương trình.");
        System.out.print("Lựa chọn: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            menu();
            int choose = input.nextInt();

            switch (choose) {
                case 1: {
                    addNewBankAccount();
                    break;
                }
                case 2: {
                    updateBalance();
                    break;
                }
                case 3: {
                    showInfoBankAccount();
                    break;
                }
                case 4: {
                    return;
                }
                default: {
                    System.out.println("Chỉ chọn từ 1->4.");
                }
            }
        }
    }

    private static void showInfoBankAccount() {
        listBankAccount.TraversalFromHead();
    }

    private static void updateBalance() {
        String accountNumber;
        double newBalance;

        System.out.print("Nhập số tài khoản cần cập nhập số dư: ");
        accountNumber = input.nextLine();

        boolean found;
        var foundNode = listBankAccount.getNode(new Bank(accountNumber));
        if (foundNode != null) {
            found = true;
        } else {
            found = false;
        }

        if (found) {
            System.out.print("Nhập số dư: ");
            newBalance = input.nextDouble();
            var data = foundNode.getData();
            data.setBalance(newBalance);
            listBankAccount.updateNodeData(foundNode, data);
            System.out.println("Cập nhập thành công !");
            input.nextLine();
        } else {
            System.out.println("Không tìm thấy số tài khoản cần cập nhập !");
        }
    }

    private static void addNewBankAccount() {
        int i = 1;
        while (true) {
            String fullName;
            String bankCardNumber;
            String accountNumber;
            String bankName;
            double balance = 0;

            System.out.println("Nhập thông tin khách hàng số " + i++ + ": ");
            System.out.print("Nhập họ và tên chủ tài khoản: ");
            fullName = input.nextLine();
            System.out.print("Nhập số thẻ: ");
            bankCardNumber = input.nextLine();
            System.out.print("Nhập số tài khoản: ");
            accountNumber = input.nextLine();
            System.out.print("Nhập tên ngân hàng: ");
            bankName = input.nextLine();


            var infoCustomer = new Bank(fullName, bankCardNumber, accountNumber, bankName, balance);
            var Customer = new DoublyLinkedList.Node<>(infoCustomer);

            var checkNode = listBankAccount.getNode(new Bank(accountNumber));
            String choose = "";
            if (checkNode == null) {
                listBankAccount.insertTail(Customer.getData());
                System.out.print("Cập nhập thành công. Bạn có muốn nhập tiếp (y/n): ");
                choose = input.nextLine();
            } else {
                System.out.print("Thông tin khách hàng đã tồn tại ! Bạn có muốn nhập tiếp (y/n): ");
                choose = input.nextLine();
                i--;
            }
            if (choose.equals("n")) break;
            System.out.println();
        }
    }
}
