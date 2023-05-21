package Array;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;
import java.util.Scanner;

public class Bai1_1 {
    Scanner input = new Scanner(System.in);

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void Bai1() {
        int t = new Scanner(System.in).nextInt();
        while (t > 0) {
            System.out.println("Nhập số phần tử của mảng: ");
            int n = new Scanner(System.in).nextInt();
            int[] arr = new int[n];

            System.out.print("Nhập mảng: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Scanner(System.in).nextInt();
            }

            for (var x: arr) {
                if (isPrime(x)) System.out.print(x + " ");
            }
            t--;
        }
    }

    public void Bai2() {
        int t = new Scanner(System.in).nextInt();
        while (t > 0) {
            System.out.println("Nhập số phần tử của mảng: ");
            int n = new Scanner(System.in).nextInt();
            int[] arr = new int[n];

            System.out.print("Nhập mảng: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new Scanner(System.in).nextInt();
            }

            int count = 0;
            for (int i = 0; i <= arr.length/2; i++) {
                if (arr[i] == arr[arr.length-1-i]) {
                    count++;
                }
            }
            if (count == arr.length/2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }
    }

    public void Bai3() {
        int t = new Scanner(System.in).nextInt();

        while (t > 0) {
            int n = new Scanner(System.in).nextInt();
            String[] strs = new String[n];

            for (int i = 0; i < strs.length; i++) {
                strs[i] = new Scanner(System.in).nextLine();
            }

            for (int i = 0; i < strs.length-1; i++) {
                for (int j = i+1; j < strs.length; j++) {
                    String temp;
                    if (strs[i].compareTo(strs[j]) > 0) {
                        temp = strs[i];
                        strs[i] = strs[j];
                        strs[j] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(strs));
            t--;
        }
    }

    public void Bai4() {
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            int x = input.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextInt();
            }

            int[] arr_new = new int[arr.length+1];
            if (k <= 0) {
                arr_new[0] = x;
                for (int i = 0; i < arr.length; i++) {
                    arr_new[i+1] = arr[i];
                }
            } else if (k >= n) {
                arr_new[arr_new.length-1] = x;
                for (int i = 0; i < arr.length; i++) {
                    arr_new[i] = arr[i];
                }
            } else {
                //Solution 1
                /*

                arr_new[k] = x;
                for (int i = 0; i < k; i++) {
                    arr_new[i] = arr[i];
                }
                for (int i = k; i < arr.length; i++) {
                    arr_new[i+1] = arr[i];
                }

                 */

                //Solution 2
                arr_new = Arrays.copyOf(arr, arr_new.length);
                arr_new[k] = x;
                for (int i = k; i < arr.length; i++) {
                    arr_new[i+1] = arr[i];
                }
            }
            System.out.println(Arrays.toString(arr_new));
            t--;
        }
    }

    public void Bai5() {
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int x = input.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextInt();
            }

            int count = 0;
            for (int a: arr) {
                if (a == x) count++;
            }

            int[] index = new int[count];

            int j = 0;
            //Đếm những chỉ số của arr với arr[i] = x
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x) {
                    index[j] = i;
                    j++;
                }
            }

            int[] arr_new = new int[arr.length-count];
            int k = 0, m = 0;
            //Gán những giá trị không trùng vào 1 mảng mới
            for (int i = 0; i < arr.length; i++) {
               if (i == index[m]) {
                   if (m < index.length-1) m++;
                   continue;
               }
                arr_new[k++] = arr[i];
            }
            System.out.println(Arrays.toString(arr_new));
            t--;
        }
    }

    public void Bai6() {
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = input.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i+1] > arr[i]) {
                    sum += arr[i+1];
                }
            }
            System.out.println(sum);
            t--;
        }
    }
}
