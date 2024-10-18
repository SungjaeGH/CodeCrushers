/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {

        HashMap<String, Integer> personalityMap = countPersonalityScore(survey, choices);

        return makePersonalityWord(personalityMap)
                .toString();
    }

    private HashMap<String, Integer> countPersonalityScore(String[] survey, int[] choices) {
        HashMap<String, Integer> personalityMap = new HashMap<>();

        for (int idx = 0; idx < survey.length; idx++) {
            String item = survey[idx];
            char[] itemArr = item.toCharArray();

            String personality = null;
            int score = 0;
            switch (choices[idx]) {
                case 1:
                    personality = String.valueOf(itemArr[0]);
                    score = 3;
                    break;

                case 2:
                    personality = String.valueOf(itemArr[0]);
                    score = 2;
                    break;

                case 3:
                    personality = String.valueOf(itemArr[0]);
                    score = 1;
                    break;

                case 5:
                    personality = String.valueOf(itemArr[1]);
                    score = 1;
                    break;

                case 6:
                    personality = String.valueOf(itemArr[1]);
                    score = 2;
                    break;

                case 7:
                    personality = String.valueOf(itemArr[1]);
                    score = 3;
                    break;

                default :
                    continue;
            }

            if (personalityMap.containsKey(personality)) {
                int prevScore = personalityMap.get(personality);
                personalityMap.put(personality, prevScore + score);

            } else {
                personalityMap.put(personality, score);
            }
        }
        return personalityMap;
    }

    private StringBuilder makePersonalityWord(HashMap<String, Integer> personalityMap) {
        String[] items = {"R", "T", "C", "F", "J", "M", "A", "N"};
        StringBuilder result = new StringBuilder();

        for (int idx = 0; idx < items.length; idx += 2) {

            int firstItem = 0, secondItem = 0;

            if (personalityMap.containsKey(items[idx])) {
                firstItem = personalityMap.get(items[idx]);
            }

            if (personalityMap.containsKey(items[idx + 1])) {
                secondItem = personalityMap.get(items[idx + 1]);
            }

            if (firstItem >= secondItem) {
                result.append(items[idx]);

            } else if (firstItem < secondItem) {
                result.append(items[idx + 1]);

            }
        }
        return result;
    }
}