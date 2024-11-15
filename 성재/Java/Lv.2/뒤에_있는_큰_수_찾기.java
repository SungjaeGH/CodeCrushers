/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int idx = numbers.length - 1; idx >= 0; idx--) {

            int number = numbers[idx];

            if (stack.isEmpty()) {
                // 이후 숫자가 없을 경우, -1
                resultList.add(-1);

            } else {

                int resultNum = -1;
                // stack의 top (뒷 수)과 앞 수를 비교해서 result 숫자 추가
                while (!stack.isEmpty()) {
                    // stack의 top 숫자
                    int lastNumber = stack.peek();

                    // 뒷 수가 크다면, 뒷 수 add
                    if (number < lastNumber) {
                        resultNum = lastNumber;
                        break;

                    } else {
                        // 앞 수가 크다면, pop
                        stack.pop();
                    }
                }

                resultList.add(resultNum);
            }

            stack.push(number);
        }

        // list 뒤집기
        Collections.reverse(resultList);

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}