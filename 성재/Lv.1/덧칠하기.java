/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */

class Solution {
    public int solution(int n, int m, int[] sections) {

        int result = 0, nextSection = 0;

        for (int section : sections) {
            if (section > nextSection) {
                result++;

                // 다음 구역의 범위 구하기
                if (section + m - 1 <= n) {
                    nextSection = section + m - 1;
                } else {
                    nextSection = n;
                }
            }
        }

        return result;
    }
}