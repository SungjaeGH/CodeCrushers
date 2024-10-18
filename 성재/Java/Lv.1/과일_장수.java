/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/135808
    m : 한 상자에 담길 사과 수
    k : 최상품 사과 점수 (1점 - 최하점)
    p : 한 상자에서 가장 낮은 사과 점수
    p * m -> 한 상자의 가격
    최대 이익을 계산
 */

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {

        Arrays.sort(score);

        int priceSum = 0;
        for (int idx = score.length - m; idx >= 0; idx -= m) {
            priceSum += score[idx] * m;
        }

        return priceSum;
    }
}