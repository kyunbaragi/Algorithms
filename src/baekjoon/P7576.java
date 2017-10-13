package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576 {
    static class Pair {
        int h;
        int w;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    static int[][] box = new int[1000][1000];
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int H = scanner.nextInt();

        int total = W * H;
        int visit = 0;

        Queue<Pair> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                box[h][w] = scanner.nextInt();

                if (box[h][w] == -1) {
                    total--;
                } else if (box[h][w] == 1) {
                    visit++;
                    queue.add(new Pair(h, w));
                }
            }
        }

        int day = 0;
        int loopCount = queue.size();
        while (true) {
            int count = 0;
            for (int i = 0; i < loopCount; i++) {
                Pair visited = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int visitH = visited.h + directions[j][0];
                    int visitW = visited.w + directions[j][1];

                    if (visitH < 0 || visitW < 0 || visitH >= H || visitW >= W) {
                        continue;
                    } else {
                        if (box[visitH][visitW] == 0) {
                            queue.add(new Pair(visitH, visitW));
                            box[visitH][visitW] = 1;
                            count++;
                        }
                    }
                }
            }



            /*for(int h = 0; h < H; h++) {
                for(int w = 0; w < W; w++) {
                    System.out.print(box[h][w] + " ");
                }
                System.out.println();
            }

            System.out.println("-----------------");*/

            if (count == 0) {
                break;
            } else {
                day++;
                visit += count;
                loopCount = queue.size();
            }
        }

        if (visit == total) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
}
