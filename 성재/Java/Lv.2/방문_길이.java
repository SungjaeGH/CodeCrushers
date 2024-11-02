/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */

import java.util.*;

class Solution {

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String dirs) {

        int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};    // 상하좌우
        HashSet<String> visited = new HashSet<>();  // 방문 기록 (xy xy)
        Point currPoint = new Point(5, 5);
        int length = 0;

        char[] dirsArr = dirs.toCharArray();
        for (char dir : dirsArr) {

            // 다음 좌표 구하기
            int moveIdx = findMoveIdx(dir);
            Point nextPoint = new Point(currPoint.x + move[moveIdx][0], currPoint.y + move[moveIdx][1]);

            // 경계를 넘어갈 경우, skip
            if (nextPoint.x < 0 || nextPoint.x > 10 || nextPoint.y < 0 | nextPoint.y > 10) {
                continue;
            }

            String pointStr = currPoint.x + "" + currPoint.y + " " + nextPoint.x + "" + nextPoint.y;
            String reversePointStr = nextPoint.x + "" + nextPoint.y + " " + currPoint.x + "" + currPoint.y;

            // 처음 방문한 길일 경우, count
            if (!visited.contains(pointStr) && !visited.contains(reversePointStr)) {
                length++;
                visited.add(pointStr);
                visited.add(reversePointStr);
            }

            currPoint = nextPoint;
        }

        return length;
    }

    private int findMoveIdx(char dir) {

        int moveIdx = -1;

        switch (dir) {
            case 'U':
                moveIdx = 0;
                break;

            case 'D':
                moveIdx = 1;
                break;

            case 'L':
                moveIdx = 2;
                break;

            case 'R':
                moveIdx = 3;
                break;

            default:
                break;
        }

        return moveIdx;
    }
}