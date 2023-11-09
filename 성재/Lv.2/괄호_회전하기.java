/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> bracket_stack = new Stack<Character>();
        char[] bracket_arr = s.toCharArray();
        LinkedList<Character> bracket_list = new LinkedList<Character>();

        // Linked list에 괄호들 추가
        for (char bracket : bracket_arr) {
            bracket_list.add(bracket);
        }

        for (int rotate_idx = 0; rotate_idx < bracket_arr.length; rotate_idx++) {
            boolean is_correct_bracket_set = true;

            for (char bracket : bracket_list) {
                if (bracket_stack.isEmpty()) {
                    if (bracket == ')' || bracket == '}' || bracket == ']') {
                        is_correct_bracket_set = false;
                        break;

                    } else {
                        bracket_stack.push(bracket);

                    }

                } else {
                    if (bracket == ')') {
                        if (bracket_stack.pop() != '(') {
                            is_correct_bracket_set = false;
                        }

                    } else if (bracket == '}') {
                        if (bracket_stack.pop() != '{') {
                            is_correct_bracket_set = false;
                        }

                    } else if (bracket == ']') {
                        if (bracket_stack.pop() != '[') {
                            is_correct_bracket_set = false;
                        }

                    } else {
                        bracket_stack.push(bracket);

                    }
                }
            }

            // 닫히지 않은 bracket이 존재할 경우, incorrect
            if (!bracket_stack.isEmpty()) {
                is_correct_bracket_set = false;
                bracket_stack.clear();
            }

            if (is_correct_bracket_set == true) {
                answer++;
            }

            // 왼쪽으로 1칸 회전
            bracket_list.addLast(bracket_list.get(0));
            bracket_list.removeFirst();
        }


        return answer;
    }
}