import java.util.Scanner;

public class SelectionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        sc.close();
    }

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_inx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_inx]) {
                    min_inx = j;
                }

            }
            int temp = arr[i];
            arr[i] = arr[min_inx];
            arr[min_inx] = temp;
        }
        System.out.println("Sorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

}
