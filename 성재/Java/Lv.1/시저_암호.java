/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */

import java.util.*;

class Solution {
    public String solution(String s, int n) {

        char[] sArr = s.toCharArray();
        StringBuffer result = new StringBuffer();

        for (char target : sArr) {
            // 공백이 들어올 경우, skip
            if (target == ' ') {
                result.append(' ');
                continue;
            }

            // 소문자가 들어올 경우
            if ('a' <= target && target <= 'z') {
                int move = target + n;
                if (move > 'z') {
                    move = 'a' + (move - 'z' - 1);
                }

                result.append((char) move);
            }

            // 대문자가 들어올 경우
            if ('A' <= target && target <= 'Z') {
                int move = target + n;
                if (move > 'Z') {
                    move = 'A' + (move - 'Z' - 1);
                }

                result.append((char) move);
            }
        }

        return result.toString();
    }
}