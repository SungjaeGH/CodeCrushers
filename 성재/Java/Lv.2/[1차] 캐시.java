/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache_list = new ArrayList<String>();

        for (String city_name : cities) {
            city_name = city_name.toLowerCase();

            int cache_idx = cache_list.indexOf(city_name);

            if (cache_idx >= 0) {
                // list에 해당 도시가 존재할 경우
                answer += 1;

                cache_list.remove(cache_idx);
                cache_list.add(city_name);

            } else {
                // list에 해당 도시가 존재하지 않을 경우
                answer += 5;

                cache_list.add(city_name);
            }

            // cache 크기가 넘었을 경우, 오랫동안 사용하지 않은 도시 삭제
            if (cache_list.size() > cacheSize) {
                cache_list.remove(0);
            }
        }

        return answer;
    }
}