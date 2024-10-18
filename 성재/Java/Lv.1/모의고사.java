/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[][] type = {{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        // user별 문제 맞춘 개수 count
        int[] scores = countScore(answers, type);

        // 최고점 확인
        int maxCount = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최고점을 맞은 user 목록 확인
        ArrayList<Integer> maxScoreList = new ArrayList<>();
        for (int userIdx = 0; userIdx < scores.length; userIdx++) {
            if (scores[userIdx] == maxCount) {
                maxScoreList.add(userIdx + 1);
            }
        }

        return maxScoreList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private int[] countScore(int[] answers, int[][] type) {

        int[] correctCount = new int[3];

        for (int answerIdx = 0; answerIdx < answers.length; answerIdx++) {
            int type1Idx = answerIdx % type[0].length;
            int type2Idx = answerIdx % type[1].length;
            int type3Idx = answerIdx % type[2].length;

            if (type[0][type1Idx] == answers[answerIdx]) {
                correctCount[0] += 1;
            }

            if (type[1][type2Idx] == answers[answerIdx]) {
                correctCount[1] += 1;
            }

            if (type[2][type3Idx] == answers[answerIdx]) {
                correctCount[2] += 1;
            }
        }

        return correctCount;
    }
}