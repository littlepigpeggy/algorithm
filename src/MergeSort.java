//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sort;

import java.util.Arrays;

public class MergeSort {
    public MergeSort() {
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R){
        if (L == R)
            return;
        //避免除法
        int mid = L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L , int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
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

    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 != null && arr2 != null) {
            if (arr1.length != arr2.length) {
                return false;
            } else {
                for(int i = 0; i < arr1.length; ++i) {
                    if (arr1[i] != arr2[i]) {
                        return false;
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 3;
        int maxValue = 10;

        for(int i = 0; i < testTime; ++i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            mergeSort(arr2);
            rightMethod(arr3);
            if (!isEqual(arr2, arr3)) {
                System.out.print("fucked.");
                System.out.print("\n");
                printArray(arr1);
                System.out.print("\n");
                printArray(arr2);
                System.out.print("\n");
                printArray(arr3);
                return;
            }
        }

        System.out.print("Nice!");
    }
}
