package sort;

import java.util.Arrays;

public class BubbleSort{
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for (int end = arr.length - 1; end > 0; -- end){
            for (int i = 0; i < end; ++ i){
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //生成随机长度的int数组
    public static int[] generateRandomArray(int size, int value){
        //生成一个1-size大小的数组
        int[] arr = new int[(int)((size * Math.random())+1)];
        for (int i = 0; i < arr.length; ++ i){
            //两个随机数相减，使其可能出现负数
            arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
        }
        return arr;
    }

    //拷贝数组
    public static int[] copyArray(int[] src){
        int[] arr = new int[src.length];
        for (int i = 0; i < arr.length; ++ i){
            arr[i] = src[i];
        }
        return arr;
    }
    //一个绝对正确的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; ++ i)
            System.out.print(arr[i]+" ");
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            return false;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; ++ i){
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTime; ++ i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            bubbleSort(arr2);
            rightMethod(arr3);
            if (!isEqual(arr2, arr3)){
                System.out.print("fucked.");
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.print("Nice!");
    }
}
