/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int row = 0; row < n; row++) {
            String format = "%0" + n + "d";
            Long wholeBinary = Long.parseLong(Integer.toBinaryString(arr1[row] | arr2[row]));

            String wholeBinaryStr = String.format(format, wholeBinary);
            wholeBinaryStr = wholeBinaryStr.replace("1", "#").replace("0", " ");

            answer[row] = wholeBinaryStr;
        }

        return answer;
    }
}