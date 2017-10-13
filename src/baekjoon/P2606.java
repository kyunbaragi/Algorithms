package baekjoon;

import java.util.Scanner;

public class P2606 {
    static boolean[] visit = new boolean[101];
    static int[][] map = new int[101][101];
    static int numOfComputer;

    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numOfComputer = scanner.nextInt();
        int numOfEdge = scanner.nextInt();

        for (int i = 0; i < numOfEdge; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);

        System.out.println(result - 1);
    }

    private static void dfs(int computer) {
        visit[computer] = true;
        result++;

        for(int i = 1; i <= numOfComputer; i++) {
            if(map[computer][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
