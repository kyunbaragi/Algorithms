package baekjoon;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/14499
 */
public class P14499 {
    static int[][] map = new int[20][20];
    static int h, w;

    static int[] dice = new int[7];

    static int curX, curY;

    static int[][] offsets = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        h = scanner.nextInt();
        w = scanner.nextInt();
        curX = scanner.nextInt();
        curY = scanner.nextInt();

        int count = scanner.nextInt();

        for(int i = 1; i <= 6; i++) {
            dice[i] = 0;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int num = scanner.nextInt();
                map[i][j] = num;
            }
        }

        int[] directions = new int[count];

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            directions[i] = num;
        }

        for (int i = 0; i < count; i++) {
            moveDice(directions[i]);
        }
    }

    private static void moveDice(int direction) {
        // check range of map
        if (curX + offsets[direction][0] >= h || curY + offsets[direction][1] >= w
                || curX + offsets[direction][0] < 0 || curY + offsets[direction][1] < 0) {
            return;
        } else {
            // move position on map
            curX += offsets[direction][0];
            curY += offsets[direction][1];

//            System.out.println(curX + " : " + curY);

            int[] temp = new int[7];
            temp[1] = dice[1];
            temp[2] = dice[2];
            temp[3] = dice[3];
            temp[4] = dice[4];
            temp[5] = dice[5];
            temp[6] = dice[6];

            // calculate number of surface
            switch (direction) {
                case 1:
                    dice[1] = temp[4];
                    dice[2] = temp[2];
                    dice[3] = temp[1];
                    dice[4] = temp[6];
                    dice[5] = temp[5];
                    dice[6] = temp[3];
                    break;
                case 2:
                    dice[1] = temp[3];
                    dice[2] = temp[2];
                    dice[3] = temp[6];
                    dice[4] = temp[1];
                    dice[5] = temp[5];
                    dice[6] = temp[4];
                    break;
                case 3:
                    dice[1] = temp[5];
                    dice[2] = temp[1];
                    dice[3] = temp[3];
                    dice[4] = temp[4];
                    dice[5] = temp[6];
                    dice[6] = temp[2];
                    break;
                case 4:
                    dice[1] = temp[2];
                    dice[2] = temp[6];
                    dice[3] = temp[3];
                    dice[4] = temp[4];
                    dice[5] = temp[1];
                    dice[6] = temp[5];
                    break;
            }

            // write number to dice
            if (map[curX][curY] == 0) {
                map[curX][curY] = dice[6];
            } else {
                dice[6] = map[curX][curY];
                map[curX][curY] = 0;
            }

            System.out.println(dice[1]);
        }
    }
}
