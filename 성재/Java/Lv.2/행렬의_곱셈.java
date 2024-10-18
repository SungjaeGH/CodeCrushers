/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */

import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr2[0].length; col++) {
                answer[row][col] = MultiElements(row, col, arr1, arr2);
            }
        }

        return answer;
    }

    private int MultiElements(int findRow, int findCol, int[][] arr1, int[][] arr2) {

        int multiResult = 0;
        int[] arr1Elements = arr1[findRow];

        for (int idx = 0; idx < arr1Elements.length; idx++) {
            multiResult += arr1Elements[idx] * arr2[idx][findCol];
        }

        return multiResult;
    }
}