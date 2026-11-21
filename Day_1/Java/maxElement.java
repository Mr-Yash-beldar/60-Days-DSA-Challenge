import java.util.*;

public class maxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give number of elements in the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr.length == 0 || arr.length == 1) {
            System.out.println(-1);

        }
        int max = arr[0];
        int smax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                smax = max;
                max = arr[i];
            }
            if (smax < arr[i] && arr[i] != max) {
                smax = arr[i];
            }
        }
        System.out.println("Second Max Element: " + smax);
        System.out.println("Max Element: " + max);
        sc.close();

    }

}
