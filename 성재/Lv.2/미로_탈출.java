/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */

import java.util.*;

class Solution {

    static int startRow;
    static int startCol;
    static int switchRow;
    static int switchCol;
    static int maxRow;
    static int maxCol;

    class Location {
        private int row;
        private int col;
        private int time;

        public Location(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int solution(String[] maps) {

        int answer = -1;
        boolean isSwitchOn = false;     // 레버 당긴 유무

        // String 배열 -> 2차원 Char 배열
        char[][] mapInfo = setMapInfo(maps);

        // 레버 찾기
        int switchCount = countMazeTime(mapInfo, isSwitchOn);
        if (switchCount > 0) {
            // 레버까지의 경로를 찾았을 경우
            isSwitchOn = true;

            // 출구 찾기
            int exitCount = countMazeTime(mapInfo, isSwitchOn);
            if (exitCount > 0) {
                // 출구까지의 경로를 찾았을 경우, 시작~레버 + 레버~출구
                answer = switchCount + exitCount;
            }
        }

        return answer;
    }

    private char[][] setMapInfo(String[] maps) {

        // 미로 사이즈 저장
        maxRow = maps.length;
        maxCol = maps[0].length();

        char[][] mapInfo = new char[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            char[] cols = maps[row].toCharArray();

            for (int col = 0; col < maxCol; col++) {

                // 시작 지점 저장
                if (cols[col] == 'S') {
                    startRow = row;
                    startCol = col;

                }

                // 레버 지점 저장
                if (cols[col] == 'L') {
                    switchRow = row;
                    switchCol = col;
                }

                mapInfo[row][col] = cols[col];
            }
        }

        return mapInfo;
    }

    private int countMazeTime(char[][] mapInfo, boolean isSwitchOn) {

        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maxRow][maxCol];
        int resultTime = -1;
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};    // 상하좌우
        int initRow = 0, initCol = 0;

        // 첫 시작지점 저장
        if (isSwitchOn) {
            initRow = switchRow;
            initCol = switchCol;

        } else {
            initRow = startRow;
            initCol = startCol;
        }

        queue.offer(new Location(initRow, initCol, 0));
        visited[initRow][initCol] = true;

        while (!queue.isEmpty()) {
            Location currLoc = queue.poll();
            char currState = mapInfo[currLoc.row][currLoc.col];

            if (isSwitchOn) {
                // 스위치가 누른 상태 + 출구 도착 시 결과 반환
                if (currState == 'E') {
                    resultTime = currLoc.time;
                    break;
                }

            } else {
                // 스위치가 최초 눌러진 상태
                if (currState == 'L') {
                    resultTime = currLoc.time;
                    break;
                }
            }

            for (int idx = 0; idx < 4; idx++) {

                Location nextLoc = new Location(
                        currLoc.row + move[idx][0],
                        currLoc.col + move[idx][1],
                        currLoc.time + 1);

                // 맵을 벗어날 경우, 패스
                if (nextLoc.row < 0 || nextLoc.col < 0 || nextLoc.row >= maxRow || nextLoc.col >= maxCol) {
                    continue;
                }

                // 이미 방문했을 경우, 패스
                if (visited[nextLoc.row][nextLoc.col]) {
                    continue;
                }

                char nextState = mapInfo[nextLoc.row][nextLoc.col];
                visited[nextLoc.row][nextLoc.col] = true;

                // 벽일 경우, 패스
                if (nextState == 'X') {
                    continue;
                }

                queue.offer(nextLoc);
            }
        }

        return resultTime;
    }
}