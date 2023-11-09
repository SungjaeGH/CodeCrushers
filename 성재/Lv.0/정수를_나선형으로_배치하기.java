/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181832
 */

import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int input_num = 1;
        int max_num = n * n;
        int row = 0, col = 0, around_count = 0;

        while (input_num <= max_num) {
            answer[row][col] = input_num;
            input_num++;

            // around 기준 (1,0 -> 2,1 -> 3,2 ...)
            if ((row == around_count + 1) && (col == around_count)) {
                around_count++;
                col++;
                continue;
            }

            // 열 증가
            if (row == around_count && col < n - 1 - around_count) {
                col++;
                continue;
            }

            // 행 증가
            if (col == n - 1 - around_count && row < n - 1 - around_count) {
                row++;
                continue;
            }

            // 열 감소
            if (row == n - 1 - around_count && col > around_count) {
                col--;
                continue;
            }

            // 행 감소
            if (col == around_count && row > around_count + 1) {
                row--;
                continue;
            }
        }

        return answer;
    }
}
