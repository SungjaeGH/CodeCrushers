/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120866
 */

import java.util.*;

class Solution {
    public int solution(int[][] board) {

        int maxRow = board.length;
        int maxCol = board[0].length;
        boolean[][] unsafeBoard = new boolean[maxRow][maxCol];
        int[][] move = {{-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}};

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                // 지뢰가 없을 경우, skip
                if (board[row][col] == 0) {
                    continue;
                }

                // 지뢰가 있을 경우
                unsafeBoard[row][col] = true;
                for (int idx = 0; idx < move.length; idx++) {
                    int unsafeRow = row + move[idx][0];
                    int unsafeCol = col + move[idx][1];

                    if (unsafeRow < 0 || unsafeRow >= maxRow || unsafeCol < 0 || unsafeCol >= maxCol) {
                        continue;
                    }

                    unsafeBoard[unsafeRow][unsafeCol] = true;
                }
            }
        }

        int answer = maxRow * maxCol;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (unsafeBoard[row][col]) {
                    answer--;
                }
            }
        }

        return answer;
    }
}