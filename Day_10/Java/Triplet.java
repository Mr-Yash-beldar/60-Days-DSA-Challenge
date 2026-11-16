import java.util.Scanner;

public class Triplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();
        System.out.println("Pair:");
        findPairsWithSum(arr, target);
        sc.close();
    }

    public static void findPairsWithSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                    }
                }
            }
        }
    }

}
