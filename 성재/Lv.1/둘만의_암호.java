/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        StringBuilder result = new StringBuilder();
        int[] sArr = s.chars().toArray();
        int[] skipArr = skip.chars().sorted().toArray();

        for (int word : sArr) {
            boolean isOver = false, isEnd = false;
            int start = word, end = start + index;

            // z가 넘어갈 경우, a에서부터 범위 재설정
            if (end > 'z') {
                end = 'a' + end - 'z' - 1;
                isOver = true;
            }

            while (!isEnd) {
                int skipCount = 0, startIdx = start, endIdx = end;

                if (isOver) {
                    isOver = false;
                    skipCount = (int) Arrays.stream(skipArr)
                            .filter(i -> (i >= startIdx && i <= 'z') || (i >= 'a' && i <= endIdx))
                            .count();

                } else {
                    skipCount = (int) Arrays.stream(skipArr)
                            .filter(i -> i >= startIdx && i <= endIdx)
                            .count();
                }

                // skip할 알파벳이 더이상 없을 경우, 종료
                if (skipCount == 0) {
                    result.append((char) endIdx);
                    isEnd = true;
                    continue;
                }

                start = endIdx + 1;
                end = start + skipCount - 1;

                if (end > 'z') {
                    end = 'a' + end - 'z' - 1;
                    isOver = true;
                }
            }
        }

        return result.toString();
    }
}