/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */

import java.util.*;

class Solution {
    void dfs(int target, boolean[] visited, int[][] computers) {
        // 방문 등록
        visited[target] = true;

        int[] computerArr = computers[target];
        for (int computerIdx = 0; computerIdx < computerArr.length; computerIdx++) {
            // 1. 동일 컴퓨터일 경우 skip
            if (computerIdx == target) {
                continue;
            }

            // 2. 이미 방문 했을 경우, 연결이 안되어 있을 경우 skip
            if (visited[computerIdx] || computerArr[computerIdx] == 0) {
                continue;
            }

            dfs(computerIdx, visited, computers);
        }
    }

    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        boolean[] visited = new boolean[n];

        for (int computerNo = 0; computerNo < n; computerNo++) {
            if (visited[computerNo]) {
                continue;
            }

            dfs(computerNo, visited, computers);
            networkCount++;
        }

        return networkCount;
    }
}