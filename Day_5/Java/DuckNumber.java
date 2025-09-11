import java.util.Scanner;

public class DuckNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = Integer.toString(n);
        if (isDuckNumber(num)) {
            System.out.println("Duck Number");
        } else {
            System.out.println("Not a Duck Number");
        }
        sc.close();
    }

    public static boolean isDuckNumber(String num) {
        if (num.charAt(0) == '0') {
            return false;
        }
        return num.contains("0");
    }

}
