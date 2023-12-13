/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = players.clone();

        for (int idx = 0; idx < players.length; idx++) {
            map.put(players[idx], idx);
        }

        for (String caller : callings) {
            int rank = map.get(caller);

            if (rank != 0) {
                String switcher = answer[rank - 1];

                map.replace(caller, rank - 1);
                map.replace(switcher, rank);

                answer[rank - 1] = caller;
                answer[rank] = switcher;
            }
        }

        return answer;
    }
}