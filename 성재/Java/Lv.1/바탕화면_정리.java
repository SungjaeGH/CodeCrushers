/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {

        int[] answer = new int[4];
        boolean isFirst = true;

        for (int row = 0; row < wallpaper.length; row++) {
            String wallpaperStr = wallpaper[row];
            StringTokenizer st = new StringTokenizer(wallpaperStr, ".|#", true);

            int col = 0;
            while (st.hasMoreTokens()) {

                String token = st.nextToken();
                if (token.equals("#")) {
                    if (isFirst) {
                        answer[0] = row;
                        answer[1] = col;
                        answer[2] = row + 1;
                        answer[3] = col + 1;

                        isFirst = false;

                    } else {
                        answer[0] = Math.min(answer[0], row);
                        answer[1] = Math.min(answer[1], col);
                        answer[2] = Math.max(answer[2], row + 1);
                        answer[3] = Math.max(answer[3], col + 1);
                    }
                }

                col++;
            }
        }

        return answer;
    }
}