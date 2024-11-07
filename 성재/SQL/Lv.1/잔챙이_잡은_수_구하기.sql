-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/293258

-- MYSQL
SELECT COUNT(*) AS 'FISH_COUNT'
FROM FISH_INFO
WHERE IFNULL(LENGTH, 0) < 10;