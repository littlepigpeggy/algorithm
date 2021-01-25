// 顺时针旋转一个矩阵 需要为方阵
// 与打印螺旋矩阵类似，分解问题 先旋转一个框

public class RotateMatrix {
    public static void rotatematrix(int[][] m){
        int left = 0;
        int right = m.length - 1;
        while (left <= right){
            rotateEdge(m, left++, right--);
        }
    }

    public static void rotateEdge(int[][] m, int left, int right){
        // 矩阵为方针, dC - tC == right - left
        int times = right - left;
        int tmp = 0;
        for (int i = 0; i < times; ++i){
            tmp = m[left][left + i];
            m[left][left + i] = m[right - i][left];
            m[right - i][left] = m[right][right - i];
            m[right][right - i] = m[left + i][right];
            m[left + i][right] = tmp;
        }
    }

    public static void printMatrix(int[][] m){
        int r = m.length;
        int c = m[0].length;
        for (int i = 0; i < r; ++i){
            for (int j = 0; j < c; ++j){
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(m);
        rotatematrix(m);
        printMatrix(m);
    }
}
