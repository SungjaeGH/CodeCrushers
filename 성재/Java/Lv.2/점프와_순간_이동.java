/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

import java.util.*;

public class Solution {
    public int solution(int n) {
        int battery_usage = 0;
        int remain_distance = n;

        while (remain_distance != 0) {
            // 2로 나눠떨어지지 않을 경우 -> 배터리 1 소모
            battery_usage += remain_distance % 2;
            remain_distance /= 2;
        }

        return battery_usage;
    }
}