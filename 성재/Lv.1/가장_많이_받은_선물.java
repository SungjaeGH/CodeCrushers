/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        // 친구들 Index 등록 및 선물 지수 등록
        HashMap<String, Integer> friendsIdx = new HashMap<>();
        HashMap<Integer, Integer> giftScore = new HashMap<>();

        for (int idx = 0; idx < friends.length; idx++) {
            friendsIdx.put(friends[idx], idx);
            giftScore.put(idx, 0);
        }

        // 선물 주고 받은 이력 (행 - 준 사람, 열 - 받은 사람) + 선물 지수 저장
        int[][] history = new int[friends.length][friends.length];

        for (String info : gifts) {
            StringTokenizer st = new StringTokenizer(info, " ");
            int giveIdx = friendsIdx.get(st.nextToken());
            int receiveIdx = friendsIdx.get(st.nextToken());

            history[giveIdx][receiveIdx] += 1;

            giftScore.put(giveIdx, giftScore.get(giveIdx) + 1);
            giftScore.put(receiveIdx, giftScore.get(receiveIdx) - 1);
        }

        // 다음달에 선물을 가장 많이 받는 사람 탐색
        int answer = 0;
        for (String friend : friends) {
            int friendIdx = friendsIdx.get(friend);
            int nextMonthReceive = 0;

            for (int idx = 0; idx < friends.length; idx++) {
                if (friendIdx == idx) {
                    continue;
                }

                int give = history[friendIdx][idx];
                int receive = history[idx][friendIdx];

                if (give > receive) {
                    // 선물을 더 많이 줬을 경우
                    nextMonthReceive++;

                } else if (give == receive) {
                    // 선물 지수가 더 높을 경우
                    if (giftScore.get(friendIdx) > giftScore.get(idx)) {
                        nextMonthReceive++;
                    }
                }
            }

            answer = Math.max(answer, nextMonthReceive);
        }

        return answer;
    }
}