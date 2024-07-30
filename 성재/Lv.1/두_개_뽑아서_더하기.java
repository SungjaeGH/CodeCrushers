/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> resultSet = new HashSet<>();

        for (int sourceIdx = 0; sourceIdx < numbers.length - 1; sourceIdx++) {
            int sourceNum = numbers[sourceIdx];

            for (int targetIdx = sourceIdx + 1; targetIdx < numbers.length; targetIdx++) {
                int targetNum = numbers[targetIdx];

                if (!resultSet.contains(sourceNum + targetNum)) {
                    resultSet.add(sourceNum + targetNum);
                }
            }
        }

        return resultSet.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}