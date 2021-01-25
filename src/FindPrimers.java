import java.util.ArrayList;
import java.util.List;

public class FindPrimers {
    public static void findPrimers1(int n) {
        boolean[] primers = new boolean[n + 1];
        for (int k = 2; k <= n / k; ++k) {
            for (int i = k; i <= n / k; ++i) {
                primers[k * i] = true;
            }
        }
        for (int i = 2; i < n; ++i) {
            if (!primers[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void findPrimers2(int n) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int number = 2;
        int squareRoot = 1;
        System.out.println("The prime numbers are\n");
        while (number <= n) {
            boolean isPrime = true;
            // squareRoot * squareRoot < number操作代替sqrt()
            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // 维护一个质数列表，判断%质数即可
            for (int k = 0; k < list.size() && list.get(k) < squareRoot; ++k) {
                if (number % list.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(number);
                System.out.print(number + " ");
            }
            number++;
        }
    }

    public static void main(String[] args) {
        findPrimers1(100);
        findPrimers2(100);
    }
}
