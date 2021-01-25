// 之字形打印矩阵 不需要为方阵
// 分解为一个个打印对角问题 定义boolean变量决定打印方向

public class ZhiPrintMatrix {
    public static void zhiPrintMatrix(int[][] m){
        int rows = m.length - 1;
        int cols = m[0].length - 1;
        int aRow = 0;
        int aCol = 0;
        int bRow = 0;
        int bCol = 0;
        // true代表从下向上打印 false相反
        boolean order = true;
        while (aRow != rows){
            if (aCol < cols && bRow < rows){
                printLevel(m, aRow, aCol++, bRow++, bCol, order);
            }
            else if (aCol == cols && bRow < rows){
                printLevel(m, aRow++, aCol, bRow++, bCol, order);
            }
            else if (aCol < cols && bRow == rows){
                printLevel(m, aRow, aCol++, bRow, bCol++, order);
            }
            else {
                printLevel(m, aRow++, aCol, bRow, bCol++, order);
            }
            order = !order;
        }
        System.out.print(m[rows][cols]);
    }

    public static void printLevel(int[][] m, int aRow, int aCol, int bRow, int bCol, boolean order) {
        // 斜向上打印
        if (order) {
            for (int row = bRow; row >= aRow; --row) {
                System.out.print(m[row][bCol++] + " ");
            }
        } else {
            for (int row = aRow; row <= bRow; ++row) {
                System.out.print(m[row][aCol--] + " ");
            }
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
        zhiPrintMatrix(m);
    }
}
