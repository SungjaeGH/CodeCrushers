/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */

import java.util.*;

class Solution {
    public int[] solution(int k, int[] scores) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int score : scores) {
            queue.offer(score);

            if (queue.size() > k) {
                queue.poll();
            }

            resultList.add(queue.peek());
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}