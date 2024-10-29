/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

class Solution {
    public int solution(int k, int[][] dungeons) {

        int maxStageCount = 0;
        boolean[] visited = new boolean[dungeons.length];

        return countMaxStage(k, 0, visited, dungeons);
    }

    private int countMaxStage(int remainK, int clearStageCount, boolean[] visited, int[][] dungeons) {

        int maxCount = clearStageCount;

        for (int i = 0; i < dungeons.length; i++) {

            if (!visited[i] && remainK >= dungeons[i][0]) {

                // 현재 던전 방문 처리
                visited[i] = true;

                // 소모 피로도 계산
                int newRemainK = remainK - dungeons[i][1];

                int currMaxCount = countMaxStage(newRemainK, clearStageCount + 1, visited, dungeons);
                maxCount = Math.max(maxCount, currMaxCount);

                // 방문 초기화
                visited[i] = false;
            }
        }

        return maxCount;
    }
}