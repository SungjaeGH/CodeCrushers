/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */

import java.util.*;

class Solution {
    public int[] solution(String msg) {

        HashMap<String, Integer> dictionary = new HashMap<>();

        // 사전 초기화
        for (int idx = 'A'; idx <= 'Z'; idx++) {
            dictionary.put(String.valueOf((char)idx), idx - 'A' + 1);
        }

        char[] msgArr = msg.toCharArray();
        StringBuilder currInput = new StringBuilder();

        int lastIdx = 26;
        int outputIdx = 0;
        ArrayList<Integer> idxList = new ArrayList<>();

        for (int idx = 0; idx < msgArr.length; idx++) {

            String curr = String.valueOf(msgArr[idx]);
            currInput.append(curr);

            if (dictionary.containsKey(currInput.toString())) {
                // 사전에 해당 단어가 존재할 경우, 해당 idx 저장
                outputIdx = dictionary.get(currInput.toString());

            } else {
                // 사전에 해당 단어가 존재하지 않을 경우
                // 해당 단어를 사전에 추가 + idxList에 저장
                dictionary.put(currInput.toString(), ++lastIdx);
                idxList.add(outputIdx);

                // 초기화
                currInput.setLength(0);
                idx--;
            }

            // 마지막 idx일 경우, 결과 idx 추가
            if (idx == msgArr.length - 1) {
                idxList.add(outputIdx);
            }
        }

        return idxList.stream().mapToInt(i -> i).toArray();
    }
}