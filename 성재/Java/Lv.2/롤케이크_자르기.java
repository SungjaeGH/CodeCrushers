/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

import java.util.*;

class Solution {
    public int solution(int[] topping) {

        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        // 동생의 토핑 먼저 세팅
        for (int type : topping) {

            if (rightMap.containsKey(type)) {
                int count = rightMap.get(type);
                rightMap.put(type, ++count);

            } else {
                rightMap.put(type, 1);

            }
        }

        int sameCount = 0;
        for (int type : topping) {
            // 철수의 토핑 추가
            if (!leftMap.containsKey(type)) {
                leftMap.put(type, 1);
            }

            // 동생의 토핑 삭제
            if (rightMap.containsKey(type)) {
                int count = rightMap.get(type);
                if (count == 1) {
                    rightMap.remove(type);

                } else {
                    rightMap.put(type, --count);
                }
            }

            // 토핑의 수가 동일하면 count
            if (leftMap.size() == rightMap.size()) {
                ++sameCount;
            }
        }

        return sameCount;
    }
}