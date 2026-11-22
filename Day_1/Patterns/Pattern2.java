
public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int s = i;
            int e = n - i + 1;
            for (int j = n; j >= 1; j--) {
                if (j % 2 != 0) {
                    System.out.print(s + " ");
                } else {
                    System.out.print(e + " ");
                }

            }
            System.out.println();
        }
    }

}
