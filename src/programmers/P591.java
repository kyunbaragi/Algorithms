package programmers;

import java.util.*;

public class P591 {
    static class Pair {
        int h;
        int w;

        public Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for (int h = 0; h < m; h++) {
            for (int w = 0; w < n; w++) {
                if (picture[h][w] == 0) {
                    continue;
                } else {
                    int color = picture[h][w];
                    int count = 0;

                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(h, w));
                    picture[h][w] = 0;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        count++;

                        for (int i = 0; i < 4; i++) {
                            int searchH = pair.h + directions[i][0];
                            int searchW = pair.w + directions[i][1];

                            if (searchH < 0 || searchW < 0 || searchH >= m || searchW >= n) {
                                continue;
                            } else {
                                if(picture[searchH][searchW] == color) {
                                    queue.add(new Pair(searchH, searchW));
                                    picture[searchH][searchW] = 0;
                                }
                            }
                        }
                    }

                    if (count > maxSizeOfOneArea) {
                        maxSizeOfOneArea = count;
                    }

                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public static void main(String[] args) {
//        int[][] picture = {{2, 1, 2, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {4, 0, 0, 3}};
//        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[][] picture = {{1, 0, 1, 1}};
        int[] result = solution(1, 4, picture);

        System.out.println(result[0] + " / " + result[1]);
    }
}
