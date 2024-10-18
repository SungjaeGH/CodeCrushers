/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int idx = 0; idx < prices.length; idx++) {
            for (int price_idx = idx; price_idx < prices.length; price_idx++) {
                if (price_idx == prices.length - 1) {
                    break;
                }

                answer[idx] += 1;

                if (prices[idx] > prices[price_idx + 1]) {
                    break;

                }
            }
        }

        return answer;
    }
}