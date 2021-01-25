public class GCD {
    public static void main(String[] args) {
        System.out.print(gcd(6, 27));
    }

    public static int gcd(int m, int n) {
        int tmp;
        while (m != 0) {
            tmp = n % m;
            n = m;
            m = tmp;
        }
        return n;
    }
}
