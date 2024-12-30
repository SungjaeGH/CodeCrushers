-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/299310
-- DATE_FORMAT (String 타입) vs YEAR(DATE 타입)

-- MYSQL
SELECT YEAR(A.DIFFERENTIATION_DATE) AS `YEAR`,
       (B.MAX_SIZE_OF_COLONY - A.SIZE_OF_COLONY) AS `YEAR_DEV`,
       A.ID
FROM ECOLI_DATA A
         INNER JOIN (SELECT YEAR(DIFFERENTIATION_DATE) AS `YEAR`,
                            MAX(SIZE_OF_COLONY) AS `MAX_SIZE_OF_COLONY`
                     FROM ECOLI_DATA
                     GROUP BY `YEAR`) B
WHERE YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY `YEAR` ASC, `YEAR_DEV` ASC;
