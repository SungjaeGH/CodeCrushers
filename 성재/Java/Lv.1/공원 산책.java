/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Boolean map[][] = new Boolean[park.length][park[0].length()];
        int[] answer = new int[2];

        for (int x = 0; x < park.length; x++) {
            char[] words = park[x].toCharArray();
            for (int y = 0; y < words.length; y++) {
                switch (words[y]) {
                    case 'S' :
                        map[x][y] = true;
                        answer[0] = x;
                        answer[1] = y;
                        break;

                    case 'O' :
                        map[x][y] = true;
                        break;

                    case 'X' :
                        map[x][y] = false;
                        break;

                    default :
                        map[x][y] = false;
                        break;
                }
            }
        }

        for (String route : routes) {
            int map_x = answer[0], map_y = answer[1];
            String[] route_info = route.split(" ");
            int move = Integer.parseInt(route_info[1]);
            Boolean is_moving = true;

            for (int move_idx = 0; move_idx < move; move_idx++) {
                switch (route_info[0]) {
                    case "N" :
                        map_x--;
                        break;

                    case "S" :
                        map_x++;
                        break;

                    case "W" :
                        map_y--;
                        break;

                    case "E" :
                        map_y++;
                        break;

                    default :
                        break;
                }

                if (map_x < 0 || map_y < 0 || map_x > map.length - 1
                        || map_y > map[0].length - 1) {
                    is_moving = false;
                    break;
                }

                if (!map[map_x][map_y]) {
                    is_moving = false;
                    break;
                }
            }

            if (is_moving) {
                answer[0] = map_x;
                answer[1] = map_y;
            }
        }

        return answer;
    }
}