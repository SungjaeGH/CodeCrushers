/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132267
 */

class Solution {
    public int solution(int a, int b, int n) {
        int bottle = 0;
        int cleanBottle = n;

        while (cleanBottle >= a) {
            bottle += (cleanBottle / a * b);
            cleanBottle = ((cleanBottle / a * b) + (cleanBottle % a));
        }

        return bottle;
    }
}