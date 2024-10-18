/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */

import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int foodIdx = 1; foodIdx < food.length; foodIdx++) {
            for (int repeat = 0; repeat < food[foodIdx] / 2; repeat++) {
                sb.append(foodIdx);
            }
        }

        return sb.toString() + '0' + sb.reverse().toString();
    }
}