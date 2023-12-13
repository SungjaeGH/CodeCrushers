-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/133025

-- MYSQL & ORACLE
SELECT A.FLAVOR AS FLAVOR
FROM FIRST_HALF A, ICECREAM_INFO B
WHERE A.FLAVOR = B.FLAVOR
  AND A.TOTAL_ORDER > 3000
  AND B.INGREDIENT_TYPE = 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC;
