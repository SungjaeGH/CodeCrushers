/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155651
    * 다시 풀어보기!!
 */

import java.util.*;

class Solution {
    public long solution(String[][] book_time) {

        long[][] bookTimeArr = new long[book_time.length][2];

        // long 2차원배열에 분 단위로 [시작,종료] 정보 세팅
        for (int idx = 0; idx < book_time.length; idx++) {
            StringTokenizer startSt = new StringTokenizer(book_time[idx][0], ":");
            StringTokenizer endSt = new StringTokenizer(book_time[idx][1], ":");

            bookTimeArr[idx][0] = Long.parseLong(startSt.nextToken()) * 60 + Long.parseLong(startSt.nextToken());
            bookTimeArr[idx][1] =  Long.parseLong(endSt.nextToken()) * 60 + Long.parseLong(endSt.nextToken()) + 10;
        }

        // 대실 시작 시간을 기준으로 정렬
        Arrays.sort(bookTimeArr, (start, end) -> {
            return Long.compare(start[0], end[0]);
        });

        // 퇴실 시간을 기준으로 정렬된 우선순위 큐
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        for (int idx = 0; idx < bookTimeArr.length; idx++) {
            long[] book = bookTimeArr[idx];

            if (!queue.isEmpty()) {
                long[] lastBookTime = queue.peek();

                if (book[0] >= lastBookTime[1]) {
                    queue.poll();
                }
            }

            queue.offer(book);
        }

        return queue.size();
    }
}