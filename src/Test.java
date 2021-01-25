import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len1 = input.nextInt();
        int[] tree1 = new int[len1];
        for (int i = 0; i < len1; ++i){
            tree1[i] = input.nextInt();
        }
        int len2 = input.nextInt();
        int[] tree2 = new int[len2];
        for (int i = 0; i < len2; ++i){
            tree2[i] = input.nextInt();
        }
        if (hasSubtree(tree1, tree2, 0, 0)){
            System.out.print("true");
        }
        else {
            System.out.print("false");
        }
        input.close();
    }

    public static boolean hasSubtree(int[] arr1, int[] arr2, int i, int j){
        if (i >= arr1.length || j >= arr2.length || arr1[i] == 0 || arr2[j] == 0){
            return false;
        }
        else {
            return isSubtree(arr1, arr2, i, j) || hasSubtree(arr1, arr2, 2 * i + 1, j) || hasSubtree(arr1, arr2, 2 * i + 2, j);
        }
    }

    public static boolean isSubtree(int[] arr1, int[] arr2, int i, int j){
        if (j >= arr2.length || arr2[j] == 0){
            return true;
        }
        if (i >= arr1.length || arr1[i] == 0){
            return false;
        }
        if (arr1[i] == arr2[j]){
            return isSubtree(arr1, arr2, 2 * i + 1, 2 * j + 1) && isSubtree(arr1, arr2, 2 * i + 2, 2 * j + 2);
        }
        return false;
    }
}
