/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */

class Solution {
    public int solution(String s) {

        int answer = 0, sameCount = 0, diffCount = 0;
        char[] sArr = s.toCharArray();
        char targetAlpha = sArr[0];

        for (int alphaIdx = 0; alphaIdx < sArr.length; alphaIdx++) {
            if (targetAlpha == sArr[alphaIdx]) {
                sameCount++;

            } else {
                diffCount++;
            }

            if (sameCount == diffCount) {
                // 목표 알파벳의 일치/불일치 개수가 동일할 경우
                answer++;
                sameCount = 0;
                diffCount = 0;

                // 다음 목표 알파벳 설정
                if (alphaIdx != sArr.length - 1) {
                    targetAlpha = sArr[alphaIdx + 1];
                }

            } else {
                // 목표 알파벳의 일치/불일치 개수가 동일하지 않는데 마지막 알파벳일 경우, count
                if (alphaIdx == sArr.length - 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
