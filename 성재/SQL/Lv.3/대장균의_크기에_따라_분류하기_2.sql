-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/301649
-- * CASE-WHEN-THEN, RANK() OVER 숙지하기!

SELECT ID,
       CASE
           WHEN (ranking <= total_len * 0.25) THEN 'CRITICAL'
           WHEN (ranking <= total_len * 0.5) THEN 'HIGH'
           WHEN (ranking <= total_len * 0.75) THEN 'MEDIUM'
           ELSE 'LOW'
           END AS `COLONY_NAME`
FROM (SELECT *,
             RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS `ranking`,
              (SELECT COUNT(*) FROM ECOLI_DATA) AS `total_len`
      FROM ECOLI_DATA) AS `A`
ORDER BY ID;