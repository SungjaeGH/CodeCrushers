-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/151136

-- MYSQL & ORACLE
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE='SUV';