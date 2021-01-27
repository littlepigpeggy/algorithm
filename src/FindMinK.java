import java.util.Arrays;

// 在一个不等的数组中找第K个数
public class FindMinK {

    public static int findMinK(int[] arr, int L, int R, int k) {
        if (L >= R) {
            return arr[L];
        } else {
            int less = partition(arr, L, R);
            if (k == less + 2) {
                return arr[less + 1];
            } else if (k < less + 2) {
                return findMinK(arr, L, less, k);
            } else {
                return findMinK(arr, less + 2, R, k - less - 2);
            }
        }
    }

    // 按照某一个元素划分
    public static int partition(int[] arr, int L, int R) {
        int num = arr[(int) (L + (R - L + 1) * Math.random())];
        int less = L - 1;
        int more = R + 1;
        int i = L;
        while (i < more) {
            if (arr[i] < num) {
                swap(arr, ++less, i++);
            } else if (arr[i] > num) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
        return less;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int rightMethod(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static int[] generateRandomArray(int size, int value) {
        //生成一个1-size大小的数组
        int[] arr = new int[(int) ((size * Math.random()) + 1)];
        for (int i = 0; i < arr.length; ++i) {
            //两个随机数相减，使其可能出现负数
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        final int k = 3;

        System.out.print(findMinK(arr, 0, arr.length - 1, k));
        System.out.print(rightMethod(arr, k));
    }
}
