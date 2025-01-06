-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/59410

-- MYSQL
SELECT ANIMAL_TYPE,
       IFNULL(NAME, 'No name') AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- ORACLE
SELECT ANIMAL_TYPE,
       NVL(NAME, 'No name') AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;