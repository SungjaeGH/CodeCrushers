/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */

import java.util.*;

class Solution {
    public int solution(String t, String p) {

        int tLen = t.length();
        int pLen = p.length();

        ArrayList<Long> partList = new ArrayList<>();
        for (int idx = 0; idx <= tLen - pLen; idx++) {
            // p의 길이만큼 문자열 자르기 (숫자 범위가 int를 넘어서기 때문에 long 사용)
            partList.add(Long.parseLong(t.substring(idx, idx + pLen)));
        }

        return (int) partList.stream()
                .filter(l -> l <= Long.parseLong(p))
                .count();
    }
}