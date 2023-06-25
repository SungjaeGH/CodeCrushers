/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> want_map = new HashMap<String, Integer>();
        for (int idx = 0; idx < want.length; idx++) {
            want_map.put(want[idx], idx);
        }

        for (int day = 0; day <= discount.length - 10; day++) {
            boolean is_valid_day = true;
            int[] cp_number = number.clone();

            for (int check_day = day; check_day < day + 10; check_day++) {
                Integer want_idx = want_map.get(discount[check_day]);
                if (want_idx != null) {
                    cp_number[want_idx] -= 1;

                }
            }

            for (int remain_want : cp_number) {
                if (remain_want != 0) {
                    is_valid_day = false;
                    break;
                }
            }

            if (is_valid_day) {
                answer++;
            }
        }

        return answer;
    }
}