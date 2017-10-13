package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7569 {
    static class Box {
        int n;
        int m;
        int h;

        Box(int n, int m, int h) {
            this.n = n;
            this.m = m;
            this.h = h;
        }
    }

    static int[][][] box = new int[100][100][100];
    static int[][] directions = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt(); // 가로
        int N = scanner.nextInt(); // 세로
        int H = scanner.nextInt(); // 높이

        int total = M * N * H;
        int visit = 0;

        Queue<Box> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {

                    box[n][m][h] = scanner.nextInt();

                    if (box[n][m][h] == -1) {
                        total--;
                    } else if (box[n][m][h] == 1) {
                        visit++;
                        queue.add(new Box(n, m, h));
                    }
                }
            }
        }

        int day = 0;
        int loop = queue.size();
        while (true) {
            int count = 0;
            for (int i = 0; i < loop; i++) {
                Box visited = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int visitN = visited.n + directions[j][0];
                    int visitM = visited.m + directions[j][1];
                    int visitH = visited.h + directions[j][2];

                    if (visitN < 0 || visitM < 0 || visitH < 0 || visitN >= N || visitM >= M || visitH >= H) {
                        continue;
                    } else {
                        if (box[visitN][visitM][visitH] == 0) {
                            queue.add(new Box(visitN, visitM, visitH));
                            box[visitN][visitM][visitH] = 1;
                            count++;
                        }
                    }
                }
            }

            /*for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    for (int m = 0; m < M; m++) {
                        System.out.print(box[n][m][h] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }

            System.out.println("-----------------------");*/

            if (count == 0) {
                break;
            } else {
                day++;
                visit += count;
                loop = queue.size();
            }
        }

        if (visit == total) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
}
