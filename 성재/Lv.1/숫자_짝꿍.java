/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */

import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        char[] xArr = X.toCharArray();
        char[] yArr = Y.toCharArray();

        // 오름차순으로 미리 정렬
        Arrays.sort(xArr);
        Arrays.sort(yArr);

        // Y에 대한 hash 세팅
        HashMap<Integer, Integer> map = setHashMap(yArr);

        // X, Y의 공통 숫자 저장
        StringBuilder sb = storeCommonNums(xArr, map);

        return sb.toString();
    }
    private HashMap<Integer, Integer> setHashMap(char[] yArr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (char numChar : yArr) {
            int num = numChar - '0';

            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, ++count);

            } else {
                map.put(num, 1);
            }
        }

        return map;
    }

    private StringBuilder storeCommonNums(char[] xArr, HashMap<Integer, Integer> map) {

        StringBuilder sb = new StringBuilder();

        for (char numChar : xArr) {
            int num = numChar - '0';

            if (map.containsKey(num)) {
                // 공통 숫자 개수에 따른 처리
                if (map.get(num) != 1) {
                    int count = map.get(num);
                    map.put(num, --count);

                } else {
                    map.remove(num);
                }

                sb.append(num);
            }
        }

        // 공통 숫자들 내림차순
        sb.reverse();

        if (sb.length() == 0) {
            // 공통 숫자가 존재하지 않을 경우, -1
            sb.append(-1);

        } else {
            // 공통 숫자가 0일 경우, 0
            if (sb.indexOf("0") == 0) {
                sb.setLength(0);
                sb.append(0);
            }
        }

        return sb;
    }
}