public class FindMinK {

    public static int findMinK(int[] arr, int L, int R, int k) {
        if (L < R) {
            int[] res = partition(arr, L, R);
            if (k < res[0] - L + 1) {
                findMinK(arr, L, res[0], k);
            } else if (res[0] - L + 1 <= k && k <= res[1] - L + 1) {
                return arr[res[0] + 1];
            } else {
                findMinK(arr, res[1], R, k - res[0] + L - 2);
            }
        }
        return -1;
    }

    public static int[] partition(int[] arr, int L, int R) {
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
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print(findMinK(arr, 0, arr.length - 1, 2));
    }
}
