/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */

import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int target_a = 0, target_b = 0;

        if (a > b) {
            target_a = b;
            target_b = a;

        } else {
            target_a = a;
            target_b = b;
        }

        int[] num_arr = new int[n];
        for (int idx = 0; idx < n; idx++) {
            num_arr[idx] = idx + 1;
        }

        int[] new_num_arr = new int[n / 2];
        int num_idx = 0, new_num_idx = 0;
        while (n != 1) {
            // a와 b가 매칭되면 break
            if (num_arr[num_idx] == target_a && num_arr[num_idx + 1] == target_b) {
                answer++;
                break;

            } else if (num_arr[num_idx] == target_a || num_arr[num_idx] == target_b) {
                new_num_arr[new_num_idx] = num_arr[num_idx];

            } else if (num_arr[num_idx + 1] == target_a || num_arr[num_idx + 1] == target_b) {
                new_num_arr[new_num_idx] = num_arr[num_idx + 1];

            } else {
                new_num_arr[new_num_idx] = num_arr[num_idx];

            }

            // new num 배열을 모두 순회했을 경우
            if (new_num_idx == (n / 2 - 1)) {
                num_idx = 0;
                new_num_idx = 0;
                n /= 2;

                num_arr = new_num_arr.clone();
                new_num_arr = new int[n / 2];

                answer++;

                continue;
            }

            num_idx += 2;
            new_num_idx++;
        }

        return answer;
    }
}

/*
[다른 풀이]
class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while(a != b)
        {
            a = a/2 + a%2;
            b = b/2 + b%2;
            round++;
        }
        return round;
    }
}

 */
