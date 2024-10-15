/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
    * 조합을 이용한 경우의 수 구하기 문제
 */

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> clothsMap = new HashMap<>();

        // HashMap에 옷 정보 저장 (key : 옷 종류, value : 경우의 수)
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];

            if (clothsMap.containsKey(type)) {
                int count = clothsMap.get(type);
                clothsMap.put(type, ++count);

            } else {
                // 경우의 수 추가 (옷 X, 옷 O인 경우 -> 2가지)
                clothsMap.put(type, 2);
            }
        }

        int answer = 1;
        for (Map.Entry<String, Integer> entry : clothsMap.entrySet()) {
            answer *= entry.getValue();
        }

        // 모든 옷을 입지 않을 경우는 제외 (-1)
        return answer - 1;
    }
}