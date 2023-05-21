package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson7 {
    /**
     * Solution:
     * Duyệt từ phần tử đầu tiên của mảng
     * Nếu phần tử đó lớn hơn phần tử nằm trước nó thì gán vào 1 biến sau đó cộng biến đếm lên 1
     * Ngược lại thì bỏ qua xét phần tử kế tiếp
     * Sau đó add hết các phần tử đó vào 1 mảng, rồi đếm số phần tử của mảng đó
     * Sau khi đếm xong, thêm tất cả phần tử vừa đếm được vào mảng lengthMin
     * Return ra giá trị lớn nhất trong mảng lengthMin
     */

    public static void main(String[] args) {
        int[] arr = {10, 22, 36, 48, 0, 1, 50, 98, 1};
        System.out.println(longestSubtrings(arr));
    }

    private static int longestSubtrings(int[] arr) {
        int[] lengthMin = new int[arr.length];
        int l = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 1;
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    continue;
                }
                count++;
            }
            int[] sort = new int[count];
            sort[0] = arr[i];
            int k = 1;
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    continue;
                }
                sort[k++] = arr[j+1];
            }
            lengthMin[l++] = sort.length;
        }
        Arrays.sort(lengthMin);
        return lengthMin[lengthMin.length-1];
    }
}
