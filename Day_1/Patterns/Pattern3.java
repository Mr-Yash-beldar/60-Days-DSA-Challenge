public class Pattern3 {

    public static void main(String[] args) {
        int N = 5;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                int value = ((j - i + N) % N) + 1;
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}