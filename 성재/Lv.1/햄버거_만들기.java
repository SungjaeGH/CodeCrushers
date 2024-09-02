/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/133502
    -> 다시 풀어볼 것!
 */

import java.util.*;

class Solution {
    public int solution(int[] ingredients) {

        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ingredient : ingredients) {

            stack.push(ingredient);

            // stack에 데이터가 4개 이상 쌓였을 경우
            if (stack.size() >= 4) {
                // 1, 2, 3, 1 순서가 아닐 경우, skip
                if (stack.get(stack.size() - 1) != 1
                        || stack.get(stack.size() - 2) != 3
                        || stack.get(stack.size() - 3) != 2
                        || stack.get(stack.size() - 4) != 1) {
                    continue;
                }

                count++;
                for (int idx = 0; idx < 4; idx++) {
                    stack.pop();
                }
            }
        }

        return count;
    }
}