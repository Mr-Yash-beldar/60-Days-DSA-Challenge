import java.util.*;

public class Thirdmax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give number of elements in the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr.length < 2) {
            System.out.println(-1);
            return;
        }
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                tmax = smax;
                smax = max;
                max = arr[i];
            }
            if (smax < arr[i] && arr[i] != max) {
                tmax = smax;
                smax = arr[i];
            }
            if (tmax < arr[i] && arr[i] != max && arr[i] != smax) {
                tmax = arr[i];
            }
        }
        System.out.println("Third Max Element: " + tmax);
        System.out.println("Second Max Element: " + smax);
        System.out.println("Max Element: " + max);
        sc.close();

    }

}
