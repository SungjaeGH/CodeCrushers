/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */

import java.util.*;

class Solution {
    static Boolean CheckWordValid(char ch) {
        if (ch < 'A' || ch > 'Z') {
            return false;
        }

        return true;
    }

    static int SetTwoWordInList(String str, ArrayList<String> str_arr_list) {
        if (str.length() == 0) {
            return 0;
        }

        str = str.toUpperCase();

        char[] str_arr = str.toCharArray();

        for (int word_idx = 0; word_idx < str_arr.length - 1; word_idx++) {
            if (CheckWordValid(str_arr[word_idx]) && CheckWordValid(str_arr[word_idx + 1])) {
                StringBuilder word = new StringBuilder();

                word.append(str_arr[word_idx]);
                word.append(str_arr[word_idx + 1]);

                System.out.println(word);

                str_arr_list.add(word.toString());
            }
        }

        return str_arr_list.size();
    }

    static int CountingIntersection(ArrayList<String> str1_arr, ArrayList<String> str2_arr) {
        int intersection_count = 0;

        if (str1_arr.size() == 0 || str2_arr.size() == 0) {
            return intersection_count;
        }

        for (String str : str1_arr) {
            int match_idx = str2_arr.indexOf(str);

            if (match_idx < 0) {
                continue;

            } else {
                intersection_count++;
                str2_arr.remove(match_idx);
            }
        }

        return intersection_count;
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        double jar_card = 1;
        ArrayList<String> str1_arr_list = new ArrayList<String>();
        ArrayList<String> str2_arr_list = new ArrayList<String>();

        int str1_count = SetTwoWordInList(str1, str1_arr_list);
        int str2_count = SetTwoWordInList(str2, str2_arr_list);

        // 교집합 & 합집합 구하기
        int intersection_count = CountingIntersection(str1_arr_list, str2_arr_list);
        int union_count = str1_count + str2_count - intersection_count;

        if (str1_count != 0 || str2_count != 0) {
            jar_card = (double) intersection_count / union_count;
        }

        return (int)(jar_card * 65536);
    }
}