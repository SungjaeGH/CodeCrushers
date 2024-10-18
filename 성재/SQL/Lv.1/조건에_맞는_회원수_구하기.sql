-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131535

-- MYSQL & ORACLE
SELECT COUNT(USER_ID) AS 'USERS'
FROM USER_INFO
WHERE JOINED LIKE '2021%' AND AGE BETWEEN 20 AND 29;