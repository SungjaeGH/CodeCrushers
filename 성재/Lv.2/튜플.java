/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */

import java.util.*;

class Solution {
    public int[] solution(String s) {

        ArrayList<ArrayList<Integer>> sList = new ArrayList<>();
        ArrayList<Integer> numList = null;

        StringTokenizer st = new StringTokenizer(s, "{ | } | ,", true);
        while (st.hasMoreTokens()) {

            String token = st.nextToken();

            if (token.equals("{")) {
                numList = new ArrayList<>();
                continue;
            }

            if (token.equals("}")) {
                if (numList != null) {
                    sList.add(numList);
                    numList = null;
                }
                continue;
            }

            if (token.equals(",")) {
                continue;
            }

            numList.add(Integer.parseInt(token));
        }

        // numList 요소의 개수에 따른 오름차순 정렬
        Collections.sort(sList, (o1, o2) -> Integer.compare(o1.size(), o2.size()));

        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(sList.get(0).get(0));

        for (int idx = 1; idx < sList.size(); idx++) {

            ArrayList<Integer> currList = new ArrayList<>(sList.get(idx));
            ArrayList<Integer> prevList = new ArrayList<>(sList.get(idx - 1));

            currList.removeAll(prevList);
            resultList.add(currList.get(0));
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}