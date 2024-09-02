/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        ArrayList<Queue<Integer>> queueList = setQueueList(board);

        return countDollsRemove(moves, queueList);
    }

    private ArrayList<Queue<Integer>> setQueueList(int[][] board) {

        ArrayList<Queue<Integer>> queueList = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int col = 0; col < board[0].length; col++) {
                if (board[col][row] == 0) {
                    continue;
                }

                queue.offer(board[col][row]);
            }

            queueList.add(queue);
        }

        return queueList;
    }

    private int countDollsRemove(int[] moves, ArrayList<Queue<Integer>> queueList) {

        Stack<Integer> stack = new Stack<>();
        int removeCount = 0;

        for (int move : moves) {
            Queue<Integer> queue = queueList.get(move - 1);
            if (queue.isEmpty()) {
                continue;
            }

            int dollIdx = queue.poll();
            if (!stack.isEmpty()) {
                if (stack.peek() == dollIdx) {
                    removeCount += 2;
                    stack.pop();
                    continue;
                }
            }

            stack.push(dollIdx);
        }

        return removeCount;
    }
}
