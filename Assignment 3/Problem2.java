import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(points[0]);
            sc.close();
            return;
        }

        int[] dp = new int[n];

        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], points[i] + dp[i - 2]);
        }

        System.out.println(dp[n - 1]);

        sc.close();
    }
}