/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12982
 */

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        int[] sort_d = Arrays.stream(d).sorted().toArray();
        for (int depart_budget : sort_d) {
            budget -= depart_budget;
            if (budget >= 0) {
                answer++;

            } else {
                break;

            }
        }

        return answer;
    }
}