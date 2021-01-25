package sort;

import java.util.Arrays;

public class HeapSort{
    public static void heapsort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; ++i){
            heapInsert(arr, i);
        }
        int heapSize = arr.length - 1;
        while (heapSize > 0){
            swap(arr, 0, heapSize--);
            heapify(arr, 0, heapSize);
        }
    }

    // 建立大根堆
    public static void heapInsert(int[] arr, int index){
        // 技巧 不用判断index (0-1)/2 = 0
        while (arr[index] > arr[(index - 1) >> 1]){
            swap(arr, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    // 结点值变化，动态调整，使其为大根堆
    public static void heapify(int[] arr, int index, int heapSize){

        int left = index << 1 + 1;
        while (left < heapSize){
            int max = left + 1 < heapSize && arr[left] > arr[left + 1] ?
                    left : left + 1;
            max = arr[max] > arr[index] ? max : index;
            if (max == index){
                break;
            }
            swap(arr, max, index);
            index = max;
            left = index * 2 + 1;
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
            heapsort(arr2);
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
