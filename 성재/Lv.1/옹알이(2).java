/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/133499
 */

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] avalibleWord = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            word = word.replace(avalibleWord[0], "0");
            word = word.replace(avalibleWord[1], "1");
            word = word.replace(avalibleWord[2], "2");
            word = word.replace(avalibleWord[3], "3");

            char[] wordArr = word.toCharArray();
            char prevNum = wordArr[0];
            boolean isAvaliable = true;

            for (int numIdx = 0; numIdx < wordArr.length; numIdx++) {
                // 숫자가 아닐 경우, 불가능
                if (wordArr[numIdx] < '0' || wordArr[numIdx] > '3') {
                    isAvaliable = false;
                    break;
                }

                // 이전 숫자와 현재 숫자를 비교해서 연속될 경우, 불가능
                if (numIdx != 0) {
                    if (wordArr[numIdx] == prevNum) {
                        isAvaliable = false;
                        break;
                    }

                    prevNum = wordArr[numIdx];
                }
            }

            if (isAvaliable) {
                answer++;
            }
        }

        return answer;
    }
}