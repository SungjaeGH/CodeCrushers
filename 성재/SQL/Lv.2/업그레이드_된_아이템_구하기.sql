-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/273711
-- * 다시 한번 풀어보기!

-- MYSQL
SELECT A.ITEM_ID, A.ITEM_NAME, A.RARITY
FROM ITEM_INFO A,
     (SELECT D.ITEM_ID
      FROM ITEM_INFO B INNER JOIN ITEM_TREE C ON B.ITEM_ID = C.ITEM_ID
                       INNER JOIN ITEM_TREE D ON C.ITEM_ID = D.PARENT_ITEM_ID
      WHERE B.RARITY = 'RARE'
     ) E
WHERE A.ITEM_ID = E.ITEM_ID
ORDER BY ITEM_ID DESC;
