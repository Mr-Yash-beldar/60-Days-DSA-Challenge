import java.util.Scanner;

public class DutchNationalFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dutch(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();

    }

    static void dutch(int arr[]) {
        int zero = 0;
        int one = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (arr[i] == 1) {
                one++;

            }

        }
        for (int i = 0; i < zero; i++) {
            arr[i] = 0;

        }
        for (int i = zero; i < zero + one; i++) {
            arr[i] = 1;
        }
        for (int i = zero + one; i < arr.length; i++) {
            arr[i] = 2;
        }

    }

}
