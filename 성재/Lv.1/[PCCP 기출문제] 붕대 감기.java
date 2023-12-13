/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */

import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int alive_time = 0, skill_time = 0, current_health = health, attack_count = 0;

        while (attack_count < attacks.length) {
            alive_time++;

            int[] attack = attacks[attack_count];

            // 공격 확인
            if (attack[0] == alive_time) {
                skill_time = 0;
                attack_count++;
                current_health -= attack[1];

                if (current_health <= 0) {
                    current_health = -1;
                    break;
                }

            } else {
                // 붕대 감기 확인
                skill_time++;

                // 체력 회복
                if (current_health < health) {
                    current_health += bandage[1];

                    if (skill_time == bandage[0]) {
                        skill_time = 0;
                        current_health += bandage[2];
                    }

                    if (current_health > health) {
                        current_health = health;
                    }
                }
            }
        }

        return current_health;
    }
}