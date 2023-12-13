/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> reporters = new HashMap<>();
        HashMap<String, Integer> suspectors = new HashMap<>();
        HashMap<String, Boolean> stoped_suspectors = new HashMap<>();
        int[] mail_result = new int[id_list.length];

        for (String report_str : report) {
            String[] report_info = report_str.split(" ");

            if (!suspectors.containsKey(report_info[1])) {
                suspectors.put(report_info[1], 0);
            }

            int count = suspectors.get(report_info[1]);

            if (!reporters.containsKey(report_info[0])) {
                ArrayList<String> suspectors_info = new ArrayList<>();
                suspectors_info.add(report_info[1]);
                reporters.put(report_info[0], suspectors_info);

                suspectors.replace(report_info[1], ++count);

            } else {
                ArrayList<String> suspectors_info = reporters.get(report_info[0]);

                if (!suspectors_info.contains(report_info[1])) {
                    suspectors_info.add(report_info[1]);

                    suspectors.replace(report_info[1], ++count);
                }
            }

            if (count >= k) {
                stoped_suspectors.put(report_info[1], true);
            }
        }

        for (int id_idx = 0; id_idx < id_list.length; id_idx++) {
            String id = id_list[id_idx];

            ArrayList<String> suspectors_info = reporters.get(id);
            if (suspectors_info != null) {
                for (String suspector : suspectors_info) {

                    if (stoped_suspectors.containsKey(suspector)) {
                        mail_result[id_idx] += 1;
                    }
                }
            }
        }

        return mail_result;
    }
}