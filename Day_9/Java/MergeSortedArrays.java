import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of arrays:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int arr1[] = new int[m];
        System.out.println("Enter First array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter Second array elements:");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        merge(arr, arr1, n, m);
        sc.close();
    }

    static void merge(int arr[], int arr1[], int n, int m) {
        int merged[] = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr[i] <= arr1[j]) {
                merged[k++] = arr[i];
                i++;
            } else {
                merged[k++] = arr1[j];
                j++;
            }
        }
        while (i < n) {
            merged[k++] = arr[i];
            i++;
        }
        while (j < m) {
            merged[k++] = arr1[j];
            j++;
        }
        System.out.println("Merged array:");
        for (int l = 0; l < merged.length; l++) {
            System.out.print(merged[l] + " ");
        }

    }
}