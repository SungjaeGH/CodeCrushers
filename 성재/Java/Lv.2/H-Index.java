/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        citations = Arrays.stream(citations).sorted().toArray();
        for (int h_idx = 0; h_idx < citations[citations.length - 1]; h_idx++) {
            int compare_idx = h_idx;

            int quotation_count = (int) Arrays.stream(citations).filter(num -> num >= compare_idx).count();

            if ((h_idx <= quotation_count) && (h_idx > answer)) {
                answer = h_idx;
            }
        }

        return answer;
    }
}