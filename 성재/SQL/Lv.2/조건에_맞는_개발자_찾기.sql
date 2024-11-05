-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132201

-- MYSQL
SELECT DISTINCT B.ID, B.EMAIL, B.FIRST_NAME, B.LAST_NAME
FROM SKILLCODES A
         JOIN DEVELOPERS B ON A.CODE & SKILL_CODE
WHERE A.NAME IN ('Python', 'C#')
ORDER BY ID;