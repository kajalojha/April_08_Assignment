package April_08_Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1_Solution {
    public int maxMoney(ArrayList<Integer> A) {
        int n = A.size();
        int[][] dp = new int[n][n];

        for (int interval = 0; interval < n; interval++) {
            for (int i = 0, j = interval; j < n; i++, j++) {
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(A.get(i) + Math.min(x, y), A.get(j) + Math.min(y, z));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q1_Solution solution = new Q1_Solution();

        System.out.println("Enter the length of the array:");
        int length = scanner.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < length; i++) {
            A.add(scanner.nextInt());
        }

        System.out.println("Maximum amount of money you can win: " + solution.maxMoney(A));
    }
}
