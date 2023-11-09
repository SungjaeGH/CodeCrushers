/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for (int size : tangerine) {
            Integer tangerine_count = map.get(size);
            if (tangerine_count == null) {
                map.put(size, 1);

            } else {
                map.remove(size);
                map.put(size, ++tangerine_count);
            }
        }

        // TreeMap의 value 값으로 정렬하기
        List<Integer> count_list = new ArrayList<Integer>(map.values());
        Collections.sort(count_list, Collections.reverseOrder());

        for (int count : count_list) {
            answer++;

            k -= count;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}