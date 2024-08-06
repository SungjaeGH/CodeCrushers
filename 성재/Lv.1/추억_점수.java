/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {

        HashMap<String, Integer> nameScoreMap = setNameScoreMap(name, yearning);
        ArrayList<Integer> resultList = new ArrayList<>();

        for (String[] photo : photos) {
            int score = 0;

            for (String targetName : photo) {
                if (nameScoreMap.containsKey(targetName)) {
                    score += nameScoreMap.get(targetName);
                }
            }

            resultList.add(score);
        }

        return resultList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private HashMap<String, Integer> setNameScoreMap(String[] name, int[] yearning) {

        HashMap<String, Integer> newMap = new HashMap<>();

        for (int idx = 0; idx < name.length; idx++) {
            newMap.put(name[idx], yearning[idx]);
        }

        return newMap;
    }
}