//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// 归并排序思想解小和问题
import java.util.Arrays;

public class smallSum {
    public smallSum() {
    }
    public static int mergeSolve(int[] arr) {
        if (arr == null || arr.length < 2){
            return 0;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    public static int sortProcess(int[] arr, int L, int R) {
        if ( L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return sortProcess(arr, L, mid) + sortProcess(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L , int mid, int R) {
        int sum = 0;
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            sum += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //两个数组必有且仅有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; ++ i){
            arr[L + i] = help[i];
        }
        return sum;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int)((double)size * Math.random() + 1.0D)];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = (int)((double)(value + 1) * Math.random()) - (int)((double)value * Math.random());
        }

        return arr;
    }

    public static int[] copyArray(int[] src) {
        int[] arr = new int[src.length];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = src[i];
        }

        return arr;
    }

    public static int rightMethod(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i){
            for (int j = 0; j < i; ++j){
                if (arr[j] < arr[i]){
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static boolean isEqual(int arr1, int arr2) {
        if (arr1 == arr2)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;

        for(int i = 0; i < testTime; ++i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            //System.out.print(rightMethod(arr3));
            if (!isEqual(mergeSolve(arr2), rightMethod(arr3))) {
                System.out.print("fucked.");
                System.out.print("\n");
                System.out.print(mergeSolve(arr2));
                System.out.print("\n");
                System.out.print(rightMethod(arr3));
                System.out.print("\n");
                printArray(arr3);
                return;
            }
        }
//        int[] arr1 = generateRandomArray(maxSize, maxValue);
//        int[] arr2 = copyArray(arr1);
//        int[] arr3 = copyArray(arr1);
//        printArray(arr3);
//        System.out.print(rightMethod(arr3));
        System.out.print("Nice!");
    }
}
