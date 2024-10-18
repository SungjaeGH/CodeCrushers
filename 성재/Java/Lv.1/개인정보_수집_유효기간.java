/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        // 현재 날짜(year.month.day) -> day로 변경
        long todayDate = changeDateToDay(today);

        // 약관 종류별 보증기간 저장된 Map 설정
        HashMap<String, Long> termsMap = new HashMap<>();
        for (String term : terms) {
            StringTokenizer termSt = new StringTokenizer(term, " ");

            String type = termSt.nextToken();
            long period = Long.parseLong(termSt.nextToken()) * 28;

            termsMap.put(type, period);
        }

        // 약관 유효기간이 만료되었는지 확인
        ArrayList<Integer> expiredList = new ArrayList<>();
        for (int privacieIdx = 1; privacieIdx <= privacies.length; privacieIdx++) {
            StringTokenizer privacieSt = new StringTokenizer(privacies[privacieIdx - 1], " ");

            long initDate = changeDateToDay(privacieSt.nextToken());
            String type = privacieSt.nextToken();

            if (initDate + termsMap.get(type) <= todayDate) {
                expiredList.add(privacieIdx);
            }
        }

        return expiredList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private long changeDateToDay(String date) {

        StringTokenizer st = new StringTokenizer(date, ".");

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        return (year * 12 * 28) + (month * 28) + day;
    }
}