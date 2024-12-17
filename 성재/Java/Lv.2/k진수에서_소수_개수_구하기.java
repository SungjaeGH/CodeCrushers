/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

import java.util.*;

class Solution {
    public int solution(int n, int k) {

        // n을 k진법으로 변경하기
        String converted = Integer.toString(n, k);

        StringTokenizer st = new StringTokenizer(converted, "0");
        int count = 0;

        while (st.hasMoreTokens()) {

            String token = st.nextToken();
            // 소수 판별하기
            if (checkDecimal(token)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkDecimal(String targetNumStr) {

        long targetNum = Long.parseLong(targetNumStr);
        boolean isDecimal = true;

        for (long idx = 2; idx <= Math.sqrt(targetNum); idx++) {
            if (targetNum % idx == 0) {
                isDecimal = false;
                break;
            }
        }

        if (targetNum == 1) {
            isDecimal = false;
        }

        return isDecimal;
    }
}