/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */


import java.util.*;

class Location {
    private final int row;
    private final int col;
    private final int distance;

    public Location(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDistance() {
        return distance;
    }
}

class Solution {
    static int bfs(int[][] maps, boolean[][] visited, int maxRow, int maxCol) {
        Queue<Location> queue = new LinkedList<>();
        int[][] move = {{0, -1},{0, 1},{-1, 0},{1, 0}}; // 상하좌우
        int resultDistance = 0;

        Location initLocation = new Location(0, 0, 1);
        queue.add(initLocation);

        while(!queue.isEmpty()) {
            Location location = queue.poll();

            int currRow = location.getRow();
            int currCol = location.getCol();
            int currDistance = location.getDistance();

            // 1. 마지막 좌표인지 확인 (마지막일 경우 길이 return)
            if ((currRow == maxRow - 1) && (currCol == maxCol - 1)) {
                resultDistance = currDistance;
                break;
            }

            int nextDistance = ++currDistance;

            // 2. 인근 행렬 확인
            for (int idx = 0; idx < 4; idx++) {
                int nextRow = currRow + move[idx][0];
                int nextCol = currCol + move[idx][1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= maxRow || nextCol >= maxCol) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && maps[nextRow][nextCol] == 1) {
                    Location addLocation = new Location(nextRow, nextCol, nextDistance);
                    queue.add(addLocation);
                }

                // 3. 방문 기록
                visited[nextRow][nextCol] = true;
            }
        }

        return resultDistance;
    }

    public int solution(int[][] maps) {
        int maxRow = maps.length;
        int maxCol = maps[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];

        int answer = bfs(maps, visited, maxRow, maxCol);
        if (!visited[maxRow - 1][maxCol - 1]) {
            answer = -1;
        }

        return answer;
    }
}

/*
 * 방문 기록 처리에 따른 효율성 차이가 난다! (1보다 2가 더 효울적)
 *  -> 1. queue에서 poll 후 방문 기록
 *  -> 2. queue에 add 후 방문 기록
 */