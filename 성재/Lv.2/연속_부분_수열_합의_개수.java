/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */

import java.util.*;

class Solution {
    public int solution(int[] elements) {

        HashSet<Integer> sumSet = new HashSet<>();

        for (int idx = 0; idx < elements.length; idx++) {
            findElementsSum(idx, 0, 1, elements, sumSet);
        }

        return sumSet.size();
    }

    private void findElementsSum(int currIdx, int lastSum, int findLen, int[] elements, HashSet<Integer> sumSet) {

        // 연속 부분 수열의 합 구하기 (이전 합 + 현재 값)
        int currSum = lastSum + elements[currIdx];
        if (!sumSet.contains(currSum)) {
            sumSet.add(currSum);
        }

        // 연속된 길이가 elements 개수와 동일할 때까지 탐색
        if (findLen != elements.length) {

            int nextIdx = (currIdx + 1) % elements.length;
            findElementsSum(nextIdx, currSum, findLen + 1, elements, sumSet);
        }
    }
}