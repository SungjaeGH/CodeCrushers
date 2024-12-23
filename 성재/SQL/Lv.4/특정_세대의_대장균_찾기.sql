-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/301650

select C.ID
from ECOLI_DATA as `A`
         INNER JOIN ECOLI_DATA AS `B` ON A.ID = B.PARENT_ID
         INNER JOIN ECOLI_DATA AS `C` ON B.ID = C.PARENT_ID
WHERE A.PARENT_ID IS NULL
ORDER BY C.ID;