import java.util.Scanner;

public class EvilNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isEvil(n)) {
            System.out.println("Evil Number");
        } else {
            System.out.println("Not an Evil Number");
        }
        sc.close();
    }

    public static boolean isEvil(int n) {
        String binary = toBinary(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count % 2 == 0;
    }

    public static String toBinary(int n) {
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary = rem + binary;
            n /= 2;
        }
        return binary;
    }

}
