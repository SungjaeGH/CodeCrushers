-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/299307

-- MYSQL
SELECT ID,
       CASE
           WHEN (SIZE_OF_COLONY <= 100) THEN 'LOW'
           WHEN (SIZE_OF_COLONY BETWEEN 100 AND 1000) THEN 'MEDIUM'
           ELSE 'HIGH'
           END AS 'SIZE'
FROM ECOLI_DATA;