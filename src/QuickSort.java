//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sort;

import java.util.Arrays;

public class QuickSort {
    public QuickSort() {
    }


    public static void quickSort(int[] arr) {
        if (arr != null && arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1 );
    }


    // 优化快速排序 时间复杂度的长期期望是O(N*logN)，额外空间复杂度是O(logN)
    // 1 对于相等的值不做处理 复杂度与快排相同 但常数参数小
    // 选用随机值对数组进行划分，减小了极端划分不均的可能
    public static void sortProcess(int[] arr, int L, int R){
        if (L < R){
            int[] space = partition(arr, L, R);
            sortProcess(arr, L, space[0]);
            sortProcess(arr, space[1], R);
        }
    }

    //荷兰国旗问题
    public static int[] partition(int[] arr, int L, int R){
        // 小于推着等于从待定区到大于
        // 随机选取一个数进行划分
        int index = L + (int)(Math.random() * (R - L)) + 1;
        int num = arr[index];
        int less = L - 1;
        int more = R + 1;
        int i = L;
        while (i < more){
            if (arr[i] < num){
                swap(arr, ++less, i++);
            }
            else if (arr[i] > num){
                swap(arr, --more, i);
            }
            else{
                ++i;
            }
        }
        return new int[] {less, more};
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
        System.out.print("\n");
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
        int maxSize = 10;
        int maxValue = 10;
//        int[] arr1 = generateRandomArray(maxSize, maxValue);
//        int[] arr2 = copyArray(arr1);
//        int[] arr3 = copyArray(arr1);
//        //printArray(arr1);
//        //partition(arr1, 0, arr1.length-1, 2);
//        //printArray(arr1);
//        rightMethod(arr2);
        //printArray(arr2);
        for(int i = 0; i < testTime; ++i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort(arr2);
            rightMethod(arr3);
            if (!isEqual(arr2, arr3)) {
                System.out.print("fucked.");
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
