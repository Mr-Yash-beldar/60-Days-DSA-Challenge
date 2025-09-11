import java.util.Scanner;

public class PetersonNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int originalNumber = n;
        int sum = 0;

        while (originalNumber > 0) {
            int digit = originalNumber % 10;
            sum += factorial(digit);
            originalNumber /= 10;
        }
        if (sum == n) {
            System.out.println("Peterson Number");
        } else {
            System.out.println("Not a Peterson Number");
        }
        sc.close();

    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

}
