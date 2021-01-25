import java.util.Scanner;

// 动态编程解斐波那契数列问题
public class Fib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index");
        int index = input.nextInt();
        System.out.print("Fib is" + fib(index));
    }

    public static long fib(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        }
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        for (int i = 3; i <= index; ++i) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }
}