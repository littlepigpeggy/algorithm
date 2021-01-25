// 在行列都排好序的矩阵中找数(N, M)
// 要求时间复杂度为O(N + M)
// 爬楼梯求解法
// leetcode-74
public class FindNumberInMatrix {
    public static boolean findNumberInMatrix(int[][] m, int k){
        int row = 0;
        int col = m[0].length - 1;
        // 取数组元素之前先问问自己下标有没有意义？
        // &&操作的懒惰性和顺序性
        // 先判断下标再取元素
        while ((row < m.length) && (col >= 0) && (m[row][col] != k)){
            if (m[row][col] > k){
                col--;
            }
            else {
                row++;
            }
        }
        if (row == m.length || col < 0){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args){
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.print(findNumberInMatrix(m, 0));
    }
}
