/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> original_container = new LinkedList<Integer>();
        Stack<Integer> help_container = new Stack<Integer>();

        // 기존 컨테이너에 상자 세팅
        for(int idx = 1; idx <= order.length; idx++) {
            original_container.offer(idx);
        }

        boolean is_original_empty = false;
        while (!(original_container.isEmpty()) || !(help_container.isEmpty())) {
            Integer original_box_num = null, help_box_num = null;

            // 기존 컨테이너 상자 가져오기
            if (!is_original_empty) {
                if (!original_container.isEmpty()) {
                    original_box_num = original_container.peek();

                } else {
                    is_original_empty = true;
                }
            }

            // 보조 컨테이너 상자 가져오기
            if (!help_container.isEmpty()) {
                help_box_num = help_container.peek();
            }

            if (is_original_empty) {
                // 기존 컨테이너 X, 보조 컨테이너 O
                if (help_box_num == order[answer]) {
                    help_container.pop();
                    answer++;

                } else {
                    // 기존 컨테이너 X, 보조 컨테이너 X -> 종료
                    break;
                }

            } else {
                boolean pop_original_box = true;

                // 기존 컨테이너 O
                if (original_box_num == order[answer]) {
                    answer++;

                } else {
                    if (help_box_num == null) {
                        help_container.push(original_box_num);

                    } else {
                        // 기존 컨테이너 X, 보조 컨테이너 O
                        if (help_box_num == order[answer]) {
                            help_container.pop();
                            answer++;
                            pop_original_box = false;

                        } else {
                            // 기존 컨테이너 X, 보조 컨테이너 X -> 보조 컨테이너에 저장
                            help_container.push(original_box_num);
                        }
                    }
                }

                if (pop_original_box) {
                    original_container.poll();
                }
            }
        }

        return answer;
    }
}