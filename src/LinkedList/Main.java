package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fullName;
        String bankCardNumber;
        String accountNumber;
        String bankName;
        double balance = 0;
        int i = 1;

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
    }
}
