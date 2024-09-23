/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120876
 */

import java.util.*;

class Solution {
    public int solution(int[][] lines) {

        // 선분의 시작 기준으로 오름차순 정렬
        Arrays.sort(lines, (start, end) -> {
            return (start[0] - end[0]);
        });

        int mixLength = 0;
        int[] prevLine = lines[0];

        for (int idx = 1; idx < lines.length; idx++) {
            int[] currLine = lines[idx];

            int mixStart = Math.max(prevLine[0], currLine[0]);
            int mixEnd = Math.min(prevLine[1], currLine[1]);

            if (mixStart < mixEnd) {
                mixLength += Math.abs(mixStart - mixEnd);
            }

            // 다음 선분 세팅
            prevLine[0] = mixEnd;
            prevLine[1] = Math.max(prevLine[1], currLine[1]);
        }

        return mixLength;
    }
}