-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/301646

-- MYSQL
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2 = 0) AND ((GENOTYPE & 1 = 1) OR (GENOTYPE & 4 = 4));