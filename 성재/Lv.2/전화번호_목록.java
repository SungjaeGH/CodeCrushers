/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        boolean answer = true;

        // 사전식으로 정렬 (119, 97674223, 1195524421) -> (119, 1195524421, 97674223)
        Arrays.sort(phone_book);

        for (int bookIdx = 0; bookIdx < phone_book.length - 1; bookIdx++) {

            String targetBook = phone_book[bookIdx];
            // targetBook의 다음 book의 접두어 비교 (사전식으로 정렬 + 포함될 경우, 탐색 종료)
            if (phone_book[bookIdx + 1].startsWith(targetBook)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}