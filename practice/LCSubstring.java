// public class LCSubstring {
//     static String longest = "";

//     public static int solve(String s1, String s2, int i, int j, int asf, String current) {

//         if (i == s1.length() || j == s2.length()) {
//             if (current.length() > longest.length())
//                 longest = current;
//             return asf;
//         }

//         int count = asf;
//         // String currString = current;

//         if (s1.charAt(i) == s2.charAt(j)) {
//             count = solve(s1, s2, i + 1, j + 1, asf + 1, current + s1.charAt(i));
//         } else {
//             if (current.length() > current.length())
//                 longest = current;
//             // currString = "";
//         }
//         int movB = solve(s1, s2, i, j + 1, 0, "");
//         int movA = solve(s1, s2, i + 1, j, 0, "");

//         return Math.max(asf, (Math.max(count, Math.max(movA, movB))));
//     }

//     public static String findLongestCommonSubstring(String s1, String s2) {
//         longest = "";
//         solve(s1, s2, 0, 0, 0, "");
//         return longest;

//     }

//    
// }

public class LCSubstring {

    public static String findans(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int maxLength = 0;
        int index = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        index = i;
                    }
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        return s1.substring(index - maxLength, index);
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcde";
        System.out.println("Longest Common Substring: " +
                findans(s1, s2));

    }
}