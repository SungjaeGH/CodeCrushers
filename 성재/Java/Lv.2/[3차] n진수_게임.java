/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder result = new StringBuilder();
        int num = 0;
        int wholeWordCount = 0;

        // 나머지 계산을 편하게 하기 위해 p를 0으로 변경
        if (m == p) {
            p = 0;
        }

        boolean isEnd = false;
        while (!isEnd) {

            // 10진수를 진법에 맞게 변경
            String changed = Integer.toString(num, n);

            char[] changedArr = changed.toCharArray();
            for (char ch : changedArr) {
                wholeWordCount++;

                // 튜브가 말해야 하는 숫자라면 append
                if (wholeWordCount % m == p) {

                    // 소문자 -> 대문자
                    if (ch >= 'a' && ch <= 'z') {
                        ch = Character.toUpperCase(ch);
                    }

                    result.append(ch);
                }

                // 튜브가 말해야 하는 숫자의 개수를 다 채우면, break
                if (result.length() == t) {
                    isEnd = true;
                    break;

                }
            }

            num++;
        }

        return result.toString();
    }
}