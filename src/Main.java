import java.util.Scanner;

public class Main {
    /**
     * @문제 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
     * @입력 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
     * @출력 첫째 줄에 경우의 수를 출력한다.
     * @예제입력 2
     * @예제출력 3
     * @힌트 아래 그림은 3×12 벽을 타일로 채운 예시이다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[num + 1];
        int result = getCount(num, dp);
        System.out.printf("%d", result);
    }

    // 3*D(N-2) + (2*D(N-4) + 2*D(N-6) + 2*D(0))
    static int getCount(int num, int[] dp) {
        if (num == 0) return 0;
        if (num == 1) return 0;
        if (num == 2) return 3;
        if (dp[num] != 0) return dp[num];

        int sum = 0;
        for (int i = 4; i <= num; i += 2) {
            sum = 2 * getCount(num - i, dp);
        }
        return dp[num] = 3 * getCount(num - 2, dp) + sum;
    }
}
