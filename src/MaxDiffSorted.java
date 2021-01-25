// 给定一个数组，求如果排序之后，相邻两数的最大差值，
// 要求时间复杂度O(N), 且不能使用非基于比较的排序

public class MaxDiffSorted{
    public static int maxDiffSorted(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 找出整个数组里的最大值和最小值
        for (int i = 0; i < len; ++i){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        //最大值 == 最小值，返回0
        if (min == max){
            return 0;
        }

        // 创建N+1个桶
        // 初始化boolean数组时，默认值为false
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];

        // 每个桶保留三个变量 hasNum; min; max
        for (int i = 0; i < len; ++i){
            int buck = bucket(arr[i], len, min, max);
            mins[buck] = hasNum[buck] ? Math.min(mins[buck], arr[i]) : arr[i];
            maxs[buck] = hasNum[buck] ? Math.max(maxs[buck], arr[i]) : arr[i];
            hasNum[buck] = true;
        }

        // 定义一个变量res来保存最后的结果
        // 若该桶非空，计算该桶的最小值与上一个桶的最大值的差值，
        // 取这些差值中的最大值即为结果
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len + 1; ++i){
            if (hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }


    public static int bucket(int num, int len, int min, int max){
        return (int)((num - min) * len / (max - min));
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    public static int[] generateRandomArray(int size, int value){
        //生成一个1-size大小的数组
        int[] arr = new int[(int)((size * Math.random())+1)];
        for (int i = 0; i < arr.length; ++ i){
            //两个随机数相减，使其可能出现负数
            arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = generateRandomArray(10, 10);
        printArray(arr);
        System.out.print(maxDiffSorted(arr));
    }
}
