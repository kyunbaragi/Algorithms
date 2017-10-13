package baekjoon;

import java.util.*;

public class P2667 {
    static int n;
    static int[][] map = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] values = line.split("");
            for (int j = 0; j < values.length; j++) {
                map[i][j] = Integer.valueOf(values[j]);
            }

        }

        int countOfArea = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    continue;
                } else {
                    int numOfHouse = 0;
                    Pair start = new Pair(i, j);

                    map[i][j] = ++countOfArea;
                    visited[i][j] = true;

                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(start);

                    while (!queue.isEmpty()) {
                        Pair visit = queue.poll();
                        numOfHouse++;

                        for (int k = 0; k < 4; k++) {
                            int searchI = visit.h + directions[k][0];
                            int searchJ = visit.w + directions[k][1];

                            if (searchI < 0 || searchJ < 0 || searchI >= n || searchJ >= n) {
                                continue;
                            } else {
                                if (map[searchI][searchJ] == 1 && !visited[searchI][searchJ]) {
                                    queue.add(new Pair(searchI, searchJ));
                                    map[searchI][searchJ] = countOfArea;
                                    visited[searchI][searchJ] = true;
                                }
                            }
                        }
                    }
                    arrayList.add(numOfHouse);
//                    System.out.println("countOfArea: " + countOfArea + " / " + "numOfHouse: " + numOfHouse);
                }
            }
        }

        System.out.println(countOfArea);
        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }

    static class Pair {
        int h;
        int w;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
