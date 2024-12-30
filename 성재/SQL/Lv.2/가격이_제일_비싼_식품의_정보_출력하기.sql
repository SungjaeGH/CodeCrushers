-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131115

-- MYSQL
SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC LIMIT 1;

-- ORACLE
SELECT *
FROM (SELECT *
      FROM FOOD_PRODUCT
      ORDER BY PRICE DESC)
WHERE ROWNUM = 1;
