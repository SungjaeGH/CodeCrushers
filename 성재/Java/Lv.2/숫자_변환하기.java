/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154538
    * TIP! target number를 구할 때 x -> y 보다 y -> x 로 탐색하는 것이 시간적으로 훨씬 유리함!!
 */

import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {

        int convertNum = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, 0});

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            if (curr[0] == x) {
                convertNum = curr[1];
                break;
            }

            for (int idx = 0; idx < 3; idx++) {

                int calculate = calculateNum(curr[0], n, idx);
                if (calculate < 0) {
                    continue;
                }

                queue.offer(new int[]{calculate, curr[1] + 1});
            }
        }

        return convertNum;
    }

    private int calculateNum(int targetNum, int n, int idx) {

        int target = -1;
        switch (idx) {
            case 0:
                target = targetNum - n;
                break;

            case 1:
                if (targetNum % 2 == 0) {
                    target = targetNum / 2;
                }
                break;

            case 2:
                if (targetNum % 3 == 0) {
                    target = targetNum / 3;
                }
                break;
        }

        return target;
    }
}