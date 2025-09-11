import java.util.Scanner;

public class BuzzNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isBuzzNumber(n)) {
            System.out.println("Buzz Number");
        } else {
            System.out.println("Not a Buzz Number");
        }
        sc.close();
    }

    public static boolean isBuzzNumber(int n) {
        return n % 7 == 0 || getLastDigit(n) == 7;
    }

    public static int getLastDigit(int n) {
        return n % 10;
    }

}
