/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17682
 */

import java.util.*;

class Solution {
    public long solution(String dartResult) {

        long[] scoreArr = new long[3];
        int currScoreIdx = -1;
        StringTokenizer st = new StringTokenizer(dartResult, "S|D|T|*|#", true);

        while (st.hasMoreTokens()) {
            boolean isScore = true;
            String token = st.nextToken();

            switch (token) {
                // 보너스 계산
                case "S" :
                    isScore = false;
                    break;
                case "D" :
                    scoreArr[currScoreIdx] = (long) Math.pow(scoreArr[currScoreIdx], 2);
                    isScore = false;
                    break;
                case "T" :
                    scoreArr[currScoreIdx] = (long) Math.pow(scoreArr[currScoreIdx], 3);
                    isScore = false;
                    break;

                // 옵션 계산
                case "*" :
                    if (currScoreIdx > 0) {
                        scoreArr[currScoreIdx - 1] *= 2;
                    }
                    scoreArr[currScoreIdx] *= 2;
                    isScore = false;
                    break;
                case "#" :
                    scoreArr[currScoreIdx] *= -1;
                    isScore = false;
                    break;
            }

            // 점수 계산
            if (isScore) {
                scoreArr[++currScoreIdx] = Long.parseLong(token);
            }
        }

        return Arrays.stream(scoreArr).sum();
    }
}