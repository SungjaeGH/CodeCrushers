-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131120

-- MYSQL
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' AND DATE_OF_BIRTH LIKE '%-03-%' AND TLNO IS NOT NULL
ORDER BY MEMBER_ID ASC;

-- ORACLE
SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(DATE_OF_BIRTH, 'yyyy-mm-dd') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' AND TLNO IS NOT NULL AND TO_CHAR(DATE_OF_BIRTH, 'mm') = 3 -- date 타입을 char 타입으로 변경 후에 값 비교 필요
ORDER BY MEMBER_ID ASC;