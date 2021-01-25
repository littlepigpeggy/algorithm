// 螺旋打印一个矩阵 不需要为方阵
// 分解问题
// 1. 打印(a,b) => (c,d)围成的框
// 2. a++, b++, c--, d--

import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public static void printSpiralMatrix(int[][] m){
        int tR = 0;
        int tC = 0;
        int dR = m.length - 1;
        int dC = m[0].length - 1;
        while(tR <= dR && tC <= dC){
            printEdge(m, tR++, tC++, dR--, dC--);

        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        if (tR == dR){
            for (int i = tC; i <= dC; ++i){
                System.out.print(m[tR][i] + " ");
            }
        }
        else if (tC == dC){
            for (int i = tR; i <= dR; ++i){
                System.out.print(m[i][tC] + " ");
            }
        }
        else {
            int curR = tR;
            int curC = tC;
            while (curC != dC){
                System.out.print(m[curR][curC] + " ");
                curC++;
            }
            while (curR != dR){
                System.out.print(m[curR][curC] + " ");
                curR++;
            }
            while (curC != tC){
                System.out.print(m[curR][curC]+ " ");
                curC--;
            }
            while (curR != tR){
                System.out.print(m[curR][curC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args){
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printSpiralMatrix(m);
    }
}
