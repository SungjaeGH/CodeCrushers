-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/298518

-- MYSQL
SELECT COUNT(*) AS 'FISH_COUNT'
FROM FISH_INFO A
         INNER JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
WHERE B.FISH_NAME IN ('BASS', 'SNAPPER');