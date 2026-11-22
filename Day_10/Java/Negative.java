import java.util.Scanner;

public class Negative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        negativeNumbers(arr);

        sc.close();
    }

    static void negativeNumbers(int[] arr) {
        int arr1[] = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr1[j] = arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                arr1[j] = arr[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");
        }

    }

}
