-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/293259

-- MYSQL
SELECT ROUND(AVG(IFNULL(LENGTH, 10)), 2) AS `AVERAGE_LENGTH`
FROM FISH_INFO;