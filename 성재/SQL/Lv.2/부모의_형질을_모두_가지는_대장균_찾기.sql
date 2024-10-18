-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131120

-- MYSQL
SELECT T1.ID,
       T1.GENOTYPE AS GENOTYPE,
       T2.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA T1 JOIN ECOLI_DATA T2
    ON T1.PARENT_ID = T2.ID
           AND (T1.GENOTYPE & T2.GENOTYPE) = T2.GENOTYPE        -- 부모 형질과 자식 형질 AND 연산 (부모 형질만 남음) ex) 3 & 1 => 1
ORDER BY T1.ID;