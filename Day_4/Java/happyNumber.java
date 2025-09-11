import java.util.*;

public class happyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isHappy(n)) {
            System.out.println("Happy Number");
        } else {
            System.out.println("Not a Happy Number");
        }
        sc.close();

    }

    public static boolean isHappy(int n) {
        ArrayList<Integer> seen = new ArrayList<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSquareSum(n);
        }
        return n == 1;
    }

    public static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}