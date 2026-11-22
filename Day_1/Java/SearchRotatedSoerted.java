import java.util.Scanner;

public class SearchRotatedSoerted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 3, 4, 5, 6, 1, 2 };

        int target = 0;
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {

            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
            } else {
                System.out.println("Element not found");
            }
            if (arr[start] <= target) {
                if (arr[0] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[n - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

    }

}
