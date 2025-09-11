import java.util.*;
import java.lang.Math;

public class Kaprekar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (isKaprekar(n)) {
            System.out.println("Kaprekar Number");
        } else {
            System.out.println("Not a Kaprekar Number");
        }

        sc.close();
    }

    public static boolean isKaprekar(int n) {
        if (n == 1)
            return true;
        if (n < 1)
            return false;

        long square = n * n;
        int numDigits = countDigits(square);

        for (int i = 1; i < numDigits; i++) {
            long divisor = (long) Math.pow(10, i);
            long right = square % divisor;
            long left = square / divisor;

            if (right != 0 && (left + right == n)) {
                return true;
            }
        }

        return false;
    }

    public static int countDigits(long num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
