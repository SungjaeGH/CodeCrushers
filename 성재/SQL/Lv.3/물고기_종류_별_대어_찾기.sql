-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/293261

-- MYSQL
SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
         INNER JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
WHERE (A.FISH_TYPE, A.LENGTH) IN (SELECT FISH_TYPE, MAX(LENGTH) AS `LENGTH`
                                  FROM FISH_INFO
                                  GROUP BY FISH_TYPE)
ORDER BY A.ID;