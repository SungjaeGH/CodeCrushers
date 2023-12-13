/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/120956
 */

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] known_words = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            for (String known_word : known_words) {
                if (word.contains(known_word)) {
                    word = word.replace(known_word, " ");
                }
            }

            word = word.replace(" ", "");

            if (word.isEmpty()) {
                answer += 1;
            }
        }

        return answer;
    }
}
