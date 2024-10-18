/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        // 완주자 정보를 hash map 세팅
        for (String people : completion) {
            if (map.containsKey(people)) {
                int count = map.get(people);
                map.put(people, ++count);
            } else {
                map.put(people, 1);
            }
        }

        for (String people : participant) {
            if (map.containsKey(people)) {
                // 참가자가 완주자 명단에 있을 경우
                int count = map.get(people);
                // 동명이인이 존재할 경우, 완주자 수 감소
                (count == 1) ? map.remove(people) : map.put(people, --count);

            } else {
                // 완주하지 못한 참가자
                answer = people;
                break;
            }
        }

        return answer;
    }
}