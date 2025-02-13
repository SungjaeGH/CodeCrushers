/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */

import java.util.*;

class Solution {
    public int solution(int[][] targets) {

        // 뒤에서부터 내림차순 정렬 하기
        Arrays.sort(targets, (o1, o2) -> {
            return o2[1] - o1[1];
        });

        int[] prevTarget = new int[]{targets[0][0], targets[0][1]};
        int count = 1;

        for (int[] target : targets) {

            // 현재 타겟의 첫지점이 이전 타겟 첫지점보다 클 경우, 위치 변경
            if (target[0] > prevTarget[0]) {
                prevTarget[0] = target[0];

                // 현재 타겟의 끝지점이 이전 타겟의 첫지점과의 접점이 없을 경우, count + 위치 변경
            } else if (target[1] <= prevTarget[0]) {
                count++;
                prevTarget[0] = target[0];
            }

            prevTarget[1] = target[1];
        }

        return count;
    }
}