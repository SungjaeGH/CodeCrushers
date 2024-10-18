/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * HashMap의 경우, char type은 지원하지 않음 -> String으로 변경해서 문제 풀자
 * (Integer) List to Array 방식 유의하기

 */

import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<Integer> resultList = new ArrayList<>();
        Map<String, Integer> alphaMap = new HashMap<>();

        char[] sArr = s.toCharArray();
        for (int idx = 0; idx < sArr.length; idx++) {
            String currAlpha = Character.toString(sArr[idx]);

            if (alphaMap.containsKey(currAlpha)) {
                // 해당 단어가 앞에서 나왔을 경우
                int prevAlphaIdx = alphaMap.get(currAlpha);
                resultList.add(idx - prevAlphaIdx);

            } else {
                // 해당 단어가 처음 나왔을 경우
                resultList.add(-1);
            }

            alphaMap.put(currAlpha, idx);
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}