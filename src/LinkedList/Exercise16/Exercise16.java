package LinkedList.Exercise16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Exercise16 {
    public static void main(String[] args) {
        int choice;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> listAcc = new ArrayList<>();

        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm mới 1 tài khoản vào danh sách.");
            System.out.println("2. Tìm và hiển thị thông tin tài khoản theo số tài khoản.");
            System.out.println("3. Xoá tài khoản có số tài khoản bằng x ra khỏi danh sách.");
            System.out.println("4. Cập nhập số dư theo số tài khoản.");
            System.out.println("5. Chuyển khoản từ số tài khoản x sang số tài khoản y trong cùng danh sách.");
            System.out.println("6. Sắp xếp danh sách tài khoản theo số dư giảm dần.");
            System.out.println("7. Tìm xem trong danh sách tài khoản có tài khoản với số thẻ x nhập vào từ bàn phím hay không.");
            System.out.println("8. Liệt kê tất cả các tài khoản trong có số thể có cụm x nhập vào từ bàn phím.");
            System.out.println("9. Liệt kê tất cả các tài khoản phát hành vào ngày x nào đó nhập vào từ bàn phím.");
            System.out.println("10. Liệt kê tất cả các tài khoản có số dư >= amount nào đó nhập vào từ bàn phím.");
            System.out.println("11. Liệt kê tất cả các tài khoản đã hết hạn tính đến ngày x nào đó nhập từ bàn phím.");
            System.out.println("12. Liệt kê tất cẩ các tài khoản có tên chủ thẻ là x nhập vào từ bàn phím.");
            System.out.println("13. Hiển thị thông tin chi tiết về các tài khoản dưới dạng bảng.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách!");
                    break;
                }
                case 1: {
                    long balance;
                    Date startDate = null;
                    Date endDate = null;
                    System.out.println("Tên chủ thẻ: ");
                    String owner = input.nextLine();
                    System.out.println("Số thẻ: ");
                    String cardNumber = input.nextLine();
                    System.out.println("Số tài khoản: ");
                    String accountNumber = input.nextLine();
                    System.out.println("Loại thẻ: ");
                    String cardType = input.nextLine();
                    System.out.println("Tên ngân hàng: ");
                    String bankName = input.nextLine();
                    System.out.println("Số dư: ");
                    balance = input.nextLong();
                    input.nextLine();
                    System.out.println("Ngày phát hành: ");
                    try {
                        startDate = dateFormat.parse(input.nextLine());
                        System.out.println("Ngày hết hạn: ");
                        endDate = dateFormat.parse(input.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    BankAccount account = new BankAccount(owner, cardNumber, accountNumber, cardType, bankName, startDate, endDate, balance);
                    listAcc.add(account);
                    break;
                }
                case 2: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản: ");
                        String accountNumber = input.nextLine();
                        int index = listAcc.indexOf(new BankAccount(accountNumber));
                        if (index != -1) {
                            System.out.println("Tìm thấy tài khoản có số tài khoản \"" + accountNumber + "\".");
                            showHeader();
                            showBankAccInfo(listAcc.get(index));
                        } else {
                            System.out.println("Tài khoản cần tìm không tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng.");
                    }
                    break;
                }
                case 3: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản: ");
                        String accountNumber = input.nextLine();
                        int index = listAcc.indexOf(new BankAccount(accountNumber));
                        if (index != -1) {
                            listAcc.remove(index);
                            System.out.println("Xoá thành công tài khoản có số tài khoản \"" + accountNumber + "\".");
                        } else {
                            System.out.println("Tài khoản cần tìm không tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 4: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số tài khoản cần cập nhập số dư: ");
                        String accountNumber = input.nextLine();
                        int index = listAcc.indexOf(new BankAccount(accountNumber));
                        if (index == -1) {
                            System.out.println("Tài khoản bạn vừa nhập không tồn tại.");
                        } else {
                            System.out.println("Nhập số dư mới: ");
                            long balance = input.nextLong();
                            BankAccount account1 = listAcc.get(index);
                            account1.setBalance(balance);
                            listAcc.set(index, account1);
                            System.out.println("Cập nhập số dư thành công!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhập số tài khoản của tài khoản nguồn: ");
                    String sourceAcc = input.nextLine();
                    int sourceIndex = listAcc.indexOf(new BankAccount(sourceAcc));
                    if (sourceIndex != -1) {
                        System.out.println("Nhập số tài khoản của tài khoản đích: ");
                        String destAcc = input.nextLine();
                        int destIndex = listAcc.indexOf(new BankAccount(destAcc));
                        if (destIndex == -1) {
                            System.out.println("Tài khoản đích không tồn tại. Vui lòng kiểm tra lại!");
                        } else {
                            System.out.println("Nhập số tiền cần chuyển: ");
                            long amount = input.nextLong();
                            if (listAcc.get(sourceIndex).withdraw(amount)) {
                                if (listAcc.get(destIndex).deposit(amount)) {
                                    System.out.println("Chuyển khoản thành công!");
                                }
                            } else {
                                System.out.println("Tài khoản gốc không đủ để thực hiện giao dịch này!");
                            }
                        }
                    } else {
                        System.out.println("Tài khoản nguồn không tồn tại. Vui lòng kiểm tra lại.");
                    }
                    break;
                }
                case 6: {
                    if (!listAcc.isEmpty()) {
                        listAcc.sort(new SortingByBalanceDESC());
                        System.out.println("Sắp xếp danh sách thành công!");
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 7: {
                    if (!listAcc.isEmpty()) {
                        int count = 0;
                        System.out.println("Nhập số thẻ: ");
                        String cardNumber = input.nextLine();
                        for (var acc: listAcc) {
                            if (acc.getCardNumber().compareTo(cardNumber) == 0) {
                                showBankAccInfo(acc);
                                count++;
                                break;
                            }
                        }
                        if (count == 0) {
                            System.out.println("Không tìm thầy tài khoản nào!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 8: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập cụm số trong số thẻ cần tìm: ");
                        String key = input.nextLine();
                        int countResult = 0;
                        showHeader();
                        for (var acc : listAcc) {
                            if (acc.getCardNumber().matches(".*" + key + ".*")) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 9: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập ngày phát hành cần tìm: ");
                        String releaseDate = input.nextLine();
                        int countResult = 0;
                        showHeader();
                        for (var acc: listAcc) {
                            if (dateFormat.format(acc.getReleaseDate()).compareTo(releaseDate) == 0) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thầy kết quả nào!");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 10: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập số dư cần tìm: ");
                        long balance = input.nextLong();
                        int countResult = 0;
                        showHeader();
                        for (var acc: listAcc) {
                            if (acc.getBalance() >= balance) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 11: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập ngày hết hạn: ");
                        String expirationDate = input.nextLine();
                        try {
                            Date giventDate = dateFormat.parse(expirationDate);
                            int countResult = 0;
                            showHeader();
                            for (var acc: listAcc) {
                                if (acc.getExpirationDate().getTime() <= giventDate.getTime()) {
                                    showBankAccInfo(acc);
                                    countResult++;
                                }
                            }
                            if (countResult == 0) {
                                System.out.println("Không tìm thấy kết quả nào.");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 12: {
                    if (!listAcc.isEmpty()) {
                        System.out.println("Nhập tên chủ thẻ: ");
                        String ownerName = input.nextLine();
                        int countResult = 0;
                        showHeader();
                        for (var acc: listAcc) {
                            int lastIndexOfSpace = acc.getOwner().lastIndexOf(" ");
                            String firstName = acc.getOwner().substring(lastIndexOfSpace + 1);
                            if (firstName.compareTo(ownerName) == 0) {
                                showBankAccInfo(acc);
                                countResult++;
                            }
                        }
                        if (countResult == 0) {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                case 13: {
                    if (!listAcc.isEmpty()) {
                        showHeader();
                        showListElements(listAcc);
                    } else {
                        System.out.println("Danh sách tài khoản rỗng!");
                    }
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void showListElements(ArrayList<BankAccount> listAcc) {
        for (var e: listAcc) {
            showBankAccInfo(e);
        }
    }

    private static void showBankAccInfo(BankAccount acc) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20d\n",
                acc.getOwner(), acc.getCardNumber(),
                acc.getAccountNumber(), acc.getCardType(),
                acc.getBankName(), format.format(acc.getReleaseDate()),
                format.format(acc.getExpirationDate()), acc.getBalance());
    }

    public static void showHeader() {
        System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20s\n",
                "Chủ thẻ", "Số thẻ", "Số TK", "Loại thẻ", "Ngân hàng",
                "Ngày PH", "Hạn SD", "Số dư");
    }
}
