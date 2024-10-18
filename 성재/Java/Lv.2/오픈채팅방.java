import java.util.*;

class Solution {
    public enum Behavier {
        ENTER,
        LEAVE,
        CHANGE
    }

    private List<String[]> setRecordList(String[] record, Map<String, String> userMap) {

        List<String[]> recordList = new ArrayList<>();

        for (String info : record) {

            String[] newRecord = new String[2];
            StringTokenizer st = new StringTokenizer(info, " ");

            String behavier = st.nextToken().toUpperCase();
            String username = st.nextToken();

            // 출입 기록 저장
            if (!behavier.equals(Behavier.CHANGE.toString())) {
                newRecord[0] = behavier;
                newRecord[1] = username;
                recordList.add(newRecord);
            }

            // 유저 닉네임 변경
            if (!behavier.equals(Behavier.LEAVE.toString())) {

                String nickname = st.nextToken();

                if (!userMap.containsKey(username)) {
                    userMap.put(username, nickname);

                } else {
                    userMap.replace(username, nickname);

                }
            }
        }

        return recordList;
    }

    private String[] makeChatMsg(List<String[]> recordList, Map<String, String> userMap) {

        List<String> resultList = new ArrayList<>();

        for (String[] info : recordList) {
            StringBuilder sb = new StringBuilder();

            sb.append(userMap.get(info[1]));
            sb.append("님이 ");
            if (info[0].equals(Behavier.ENTER.toString())) {
                sb.append("들어왔습니다.");
            } else {
                sb.append("나갔습니다.");
            }

            resultList.add(sb.toString());
        }

        return resultList.toArray(new String[resultList.size()]);
    }

    public String[] solution(String[] record) {

        Map<String, String> userMap = new HashMap<>();
        List<String[]> recordList = setRecordList(record, userMap);

        return makeChatMsg(recordList, userMap);
    }
}