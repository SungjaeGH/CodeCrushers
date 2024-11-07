/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17686
    * 정렬 기준을 custom 해야할 경우, compare을 override하여 사용하자!
    * String -> str1.compareTo(str2)
    * Integer -> Integer.compare(num1, num2)
    * Char -> Character.compare(ch1, ch2)
 */

import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {

                String[] word1Token = word1.split("[0-9]");
                String[] word2Token = word2.split("[0-9]");

                String head1 = word1Token[0].toLowerCase();
                String head2 = word2Token[0].toLowerCase();

                int result = head1.compareTo(head2);
                if (result == 0) {
                    result = compareNumber(word1, word2);
                }

                return result;
            }
        });

        return files;
    }

    private int compareNumber(String word1, String word2) {

        String[] word1Arr = word1.split("[^0-9]+");
        String[] word2Arr = word2.split("[^0-9]+");

        int number1 = Integer.parseInt(word1Arr[1]);
        int number2 = Integer.parseInt(word2Arr[1]);

        return Integer.compare(number1, number2);
    }
}