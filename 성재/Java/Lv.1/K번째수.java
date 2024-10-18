/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int commandIdx = 0; commandIdx < commands.length; commandIdx++) {
            int[] command = commands[commandIdx];

            int[] splitArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(splitArr);

            resultList.add(splitArr[command[2] - 1]);
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}