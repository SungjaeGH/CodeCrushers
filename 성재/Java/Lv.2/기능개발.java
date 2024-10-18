/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer_list = new ArrayList<Integer>();

        Queue<int[]> working_seq_queue = new LinkedList<int[]>();
        for (int idx = 0; idx < progresses.length; idx++) {
            int[] working_set = new int[2];
            working_set[0] = progresses[idx];
            working_set[1] = speeds[idx];

            working_seq_queue.offer(working_set);
        }

        int last_distribution_day = 0;
        int working_count = 0;

        while (!working_seq_queue.isEmpty()) {
            int[] working_set = working_seq_queue.poll();
            int working_day = 0;

            // 배포까지 작업 일자 확인
            if ((100 - working_set[0]) % working_set[1] == 0) {
                working_day = (100 - working_set[0]) / working_set[1];

            } else {
                working_day = (100 - working_set[0]) / working_set[1] + 1;
            }

            if (working_day > last_distribution_day) {
                if (last_distribution_day != 0) {
                    answer_list.add(working_count);
                }

                last_distribution_day = working_day;
                working_count = 0;
            }

            working_count++;
        }

        // 마지막 남은 작업 개수 추가
        answer_list.add(working_count);

        return answer_list.stream().mapToInt(Integer::intValue).toArray();
    }
}