package DynamicProgramming;

import java.util.Scanner;

public class Lesson9 {
    /**
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … là các số xấu xí, ta chia chúng thành 3 nhóm:
     * 1. Tích của 2 với các số: 1*2, 2*2, 2*3, 2*4,...
     * 2. Tích của 3 với các số: 1*3, 3*2, 3*3, 3*4,...
     * 3. Tích của 5 với các số: 1*5, 5*2, 5*3, 5*4,...
     * Lấy phần tử nhỏ nhất trong 3 nhóm
     * tiếp tục đến hết
     */

    //Bottom-up
    public static void main(String[] args) {
        System.out.println("Nhập số nguyên dương n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.printf("Số xấu xí thứ %d = %d\n", n, findUglyNumberN(n));
    }
    /**
     * Phương thức dùng để tìm số xấu xí thứ n.
     * B1. Khai báo một mảng số xấu xí gồm n phần tử: ugly[n]
     * B2. Khởi tạo số xấu xí đầu tiên: ugly[0] = 1;
     * B3. khởi tạo 3 chỉ số mảng i2, i3, i5 để trỏ tới phần tử thứ nhất trong mảng ugly: i2 = i3 = i5 = 0;
     * B4. khởi tạo 3 lựa chọn cho số xấu xí kế tiếp:
     *      nextMultilpleOf2 = ugly[i2] * 2;
     *      nextMultilpleOf3 = ugly[i3] * 3;
     *      nextMultilpleOf5 = ugly[i5] * 5;
     * B5. Bây giờ lặp để điền tất cả các số xấu xí đến n:
     *  for i in [1, n - 1]:
     *      nextUglyNumber = min(nextMultilpleOf2, nextMultilpleOf3, nextMultilpleOf5);
     *      ugly[i] = nextUglyNumber;
     *      if(nextUglyNumber == nextMultilpleOf2):
     *          i2++;
     *          nextMultilpleOf2 = ugly[i2] * 2;
     *      if(nextUglyNumber == nextMultilpleOf3):
     *          i3++;
     *          nextMultilpleOf3 = ugly[i3] * 3;
     *      if(nextUglyNumber == nextMultilpleOf5):
     *          i5++;
     *          nextMultilpleOf5 = ugly[i5] * 5;
     * B6. trả về số xấu xí tiếp theo
     *
     * @param n thứ tự số xấu xí cần tìm
     * @return số xấu xí thứ n
     */
    private static int findUglyNumberN(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int nextUglyNumber = 1;
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUglyNumber;
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = ugly[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = ugly[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = ugly[i5] * 5;
            }
        }
        return ugly[n-1];
    }
}
