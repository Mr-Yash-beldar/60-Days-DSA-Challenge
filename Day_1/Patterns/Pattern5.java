class Pattern5 {
    public static void main(String[] args) {
        int n = 5;
        int mid = n / 2 + 1;
        for (int i = 1; i <= mid; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            int max = mid - i + 1;
            for (int j = 1; j <= max; j++) {
                System.out.print(j + " ");
            }
            for (int j = max - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = mid - 1; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }
            int max = mid - i + 1;
            for (int j = 1; j <= max; j++) {
                System.out.print(j + " ");
            }
            for (int j = max - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}