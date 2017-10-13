package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
    static class Pair {
        int h;
        int w;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    static int H;
    static int W;
    static int[][] map = new int[100][100];
    static int[][] distance = new int[100][100];
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] temp1 = line.split(" ");
        H = Integer.parseInt(temp1[0]);
        W = Integer.parseInt(temp1[1]);

        for (int h = 0; h < H; h++) {
            String row = scanner.nextLine();
            String[] temp = row.split("");

            for (int w = 0; w < W; w++) {
                map[h][w] = Integer.parseInt(temp[w]);
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair visited = queue.poll();

            for (int i = 0; i < directions.length; i++) {
                int visitH = visited.h + directions[i][0];
                int visitW = visited.w + directions[i][1];

                if (visitH < 0 || visitW < 0 || visitH >= H || visitW >= W) {
                    continue;
                } else {
                    if (map[visitH][visitW] != 0 && distance[visitH][visitW] == 0) {
                        distance[visitH][visitW] = distance[visited.h][visited.w] + 1;
                        queue.add(new Pair(visitH, visitW));
                    }
                }
            }

            /*for(int h = 0; h < H; h++) {
                for(int w = 0; w < W; w++) {
                    System.out.print(distance[h][w] + " ");
                }
                System.out.println();
            }
            System.out.println("-----------------");*/
        }

        System.out.println(distance[H - 1][W - 1]);
    }
}
