/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        ArrayList<Integer> result = new ArrayList<>();

        for (String target : targets) {
            int total = 0;
            char[] alphaArr = target.toCharArray();

            for (char alpha : alphaArr) {
                int min = 0;

                for (String key : keymap) {
                    int loc = key.indexOf(alpha);
                    if (loc == -1) {
                        continue;
                    }

                    loc++;
                    if (min == 0 || loc < min) {
                        min = loc;
                    }
                }

                if (min == 0) {
                    total = -1;
                    break;
                }

                total += min;
            }

            result.add(total);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
