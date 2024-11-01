-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/299305

-- MYSQL
SELECT A.ID, IFNULL(D.CHILD_COUNT, 0) AS 'CHILD_COUNT'
FROM ECOLI_DATA A
         LEFT OUTER JOIN (SELECT B.ID, COUNT(C.ID) AS 'CHILD_COUNT'
                          FROM ECOLI_DATA B
                                   INNER JOIN ECOLI_DATA C
                                              ON B.ID = C.PARENT_ID
                          GROUP BY B.ID) D
                         ON A.ID = D.ID
ORDER BY A.ID;

/*
아래 SQL문이 더 간단하다!
SELECT A.ID, COUNT(B.ID) AS 'CHILD_COUNT'
FROM ECOLI_DATA A LEFT OUTER JOIN ECOLI_DATA B
    ON A.ID = B.PARENT_ID
GROUP BY A.ID
ORDER BY A.ID;
*/