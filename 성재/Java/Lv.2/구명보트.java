/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42885
=> 투포인터 대표 문제!
 */

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] sort_people = Arrays.stream(people).sorted().toArray();

        int start_point = 0, end_point = sort_people.length - 1;

        while (start_point <= end_point) {
            // 구명보트에 타지 못한사람이 한명밖에 없을 경우
            if (start_point == end_point) {
                answer++;
                break;
            }

            // (무게가 적게 나가는 사람 + 무게가 많이 나가는 사람)과 limit 비교
            if (sort_people[start_point] + sort_people[end_point] > limit) {
                // 무게가 많이 나가는 사람만 태우기
                answer++;
                end_point--;

            } else {
                // 둘 다 태우기
                answer++;
                start_point++;
                end_point--;
            }
        }

        return answer;
    }
}