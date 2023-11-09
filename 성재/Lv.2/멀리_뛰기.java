/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */

class Solution {
    static long AddFunc(int plus_idx, int max_count, long prev_answer, long answer) {         plus_idx++;

        if (plus_idx <= max_count) {
            long tmp_num = answer;

            answer = (answer + prev_answer) % 1234567;
            prev_answer = tmp_num;

            return AddFunc(plus_idx, max_count, prev_answer, answer);
        }

        return answer;
    }

    public long solution(int n) {
        long answer = 2, prev_answer = 1;
        int plus_idx = 2;

        if (n > 2) {
            answer = AddFunc(plus_idx, n, prev_answer, answer);

        } else {
            answer = n;

        }

        return answer;
    }
}