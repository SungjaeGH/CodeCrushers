/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12953
    * 최소공배수 : 해당하는 수들의 배수 중 공통된 수 중 최소값 (1. 모든 공통 배수 중 가장 최소값, 2. 모든 값 소인수분해 후, 공통된 소인수값들 중 큰값 모두 곱셈)
    * N의 제곱근까지 반복 돌리는 부분에 대해 이해할 필요가 있음! (divNum <= Math.sqrt(targetNum) , divNum * divNum <= targetNum)
    * ex) 입력 값       -> 2, 6, 18
          소인수 분해 시  -> 2, 2 * 3, 2 * 3 * 3
          최소공배수     -> 2(1개가 최대), 3(2개가 최대) == 2 * 3 * 3 = 18
 */

import java.util.*;

class Solution {
    public int solution(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int targetNum : arr) {

            // 1, 2일 경우 map에 저장 후, skip
            if (targetNum <= 2) {
                map.put(targetNum, 1);
                continue;
            }

            for (int divNum = 2; divNum <= Math.sqrt(targetNum); divNum++) {

                // 더이상 나눌 수가 없을 경우, break
                if (targetNum <= 1) {
                    break;
                }

                // 해당 값을 나눌 수 없을 때까지 나누기
                int currCount = 0;
                while (targetNum % divNum == 0) {
                    targetNum /= divNum;
                    currCount++;
                }

                // 해당 값을 나눌 수가 없을 경우, skip
                if (currCount == 0) {
                    continue;
                }

                int prevCount = 0;
                if (map.containsKey(divNum)) {
                    prevCount = map.get(divNum);
                }

                map.put(divNum, Math.max(prevCount, currCount));
            }

            if (targetNum != 1) {
                if (!map.containsKey(targetNum)) {
                    map.put(targetNum, 1);
                }
            }
        }

        // 소인수분해된 모든 값 곱하기
        int result = 1;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            result *= Math.pow(key, map.get(key));
        }

        return result;
    }
}