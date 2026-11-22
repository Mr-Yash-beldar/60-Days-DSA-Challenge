class Pattern1 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                for (int j = n; j >= 1; j--) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}