/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */

import java.util.*;

class Solution {
    public int solution(String s) {

        return replaceWordToNum(s);
    }

    private int replaceWordToNum(String s) {

        String[] wordArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int idx = 0; idx <= 9; idx++) {
            s = s.replace(wordArr[idx], String.valueOf(idx));
        }

        return Integer.parseInt(s);
    }
}
