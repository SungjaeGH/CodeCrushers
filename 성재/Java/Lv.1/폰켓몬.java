/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int count = nums.length / 2;
        HashSet<Integer> types = new HashSet<>();

        for (int num : nums) {
            types.add(num);
        }

        return count > types.size() ? types.size() : count;
    }
}