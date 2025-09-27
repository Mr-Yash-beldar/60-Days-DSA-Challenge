import java.util.Scanner;

public class SubArrayGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        System.out.println("Enter the sum to be found:");
        int sum = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        subArraySum(arr, sum);

        sc.close();
    }

    static void subArraySum(int arr[], int sum) {
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            while (currentSum > sum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == sum) {

                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }

            }

        }

    }

}
