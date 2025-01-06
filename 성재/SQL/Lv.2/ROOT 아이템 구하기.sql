-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/273710

-- MYSQL
-- 첫번째 방법
SELECT A.ITEM_ID, A.ITEM_NAME
FROM ITEM_INFO A
    INNER JOIN ITEM_TREE B ON A.ITEM_ID = B.ITEM_ID
WHERE B.PARENT_ITEM_ID IS NULL;

-- 두번째 방법
SELECT ITEM_ID, ITEM_NAME
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT ITEM_ID
                  FROM ITEM_TREE
                  WHERE PARENT_ITEM_ID IS NULL);

-- * 성능 : 첫번째 > 두번째