/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12921
 */

import java.util.*;

class Solution {
    public long solution(int n) {

        int[] checkDecimal = new int[n + 1];

        // 배열 초기화 (0, 1은 소수가 아니기 때문에 2부터 초기화)
        for (int idx = 2; idx <= n; idx++) {
            checkDecimal[idx] = idx;
        }

        for (int targetNum = 2; targetNum <= n; targetNum++) {
            // 소수가 아닐 경우, skip
            if (checkDecimal[targetNum] == 0) {
                continue;
            }

            // 배수가 되는 값들은 소수가 될 수 없기 때문에 0 처리
            for (int mul = 2 * targetNum; mul <= n; mul += targetNum) {
                checkDecimal[mul] = 0;
            }
        }

        return Arrays.stream(checkDecimal).filter(i -> i > 0).count();
    }
}