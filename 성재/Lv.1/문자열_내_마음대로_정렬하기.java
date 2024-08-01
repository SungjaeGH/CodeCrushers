/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for (String s : strings) {
            int targetIdx = s.charAt(n);

            queue.offer(targetIdx);

            if (map.containsKey(targetIdx)) {
                map.get(targetIdx).add(s);

            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(targetIdx, newList);
            }
        }

        ArrayList<String> resultArr = new ArrayList<>();

        while (!queue.isEmpty()) {
            int targetIdx = queue.poll();

            if (map.containsKey(targetIdx)) {
                ArrayList<String> sList = map.get(targetIdx);
                sList.stream().sorted()
                        .forEach(s -> resultArr.add(s));

                map.remove(targetIdx);
            }
        }

        return resultArr
                .toArray(new String[resultArr.size()]);
    }
}