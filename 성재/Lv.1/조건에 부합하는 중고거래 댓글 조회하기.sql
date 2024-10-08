-- 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/164673

-- MYSQL
SELECT BOARD.TITLE AS TITLE,
       BOARD.BOARD_ID AS BOARD_ID,
       REPLY.REPLY_ID AS REPLY_ID,
       REPLY.WRITER_ID AS WRITER_ID,
       REPLY.CONTENTS AS CONTENTS,
       DATE_FORMAT(REPLY.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD BOARD INNER JOIN USED_GOODS_REPLY REPLY
                                       ON BOARD.BOARD_ID = REPLY.BOARD_ID
WHERE DATE_FORMAT(BOARD.CREATED_DATE, '%Y-%m') LIKE '2022-10'
ORDER BY REPLY.CREATED_DATE ASC, BOARD.TITLE ASC;

SELECT BOARD.TITLE AS TITLE,
       BOARD.BOARD_ID AS BOARD_ID,
       REPLY.REPLY_ID AS REPLY_ID,
       REPLY.WRITER_ID AS WRITER_ID,
       REPLY.CONTENTS AS CONTENTS,
       DATE_FORMAT(REPLY.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD BOARD, USED_GOODS_REPLY REPLY
WHERE BOARD.BOARD_ID = REPLY.BOARD_ID
  AND DATE_FORMAT(BOARD.CREATED_DATE, '%Y-%m') LIKE '2022-10'
ORDER BY REPLY.CREATED_DATE ASC, BOARD.TITLE ASC;

-- ORACLE
SELECT BOARD.TITLE AS TITLE,
       BOARD.BOARD_ID AS BOARD_ID,
       REPLY.REPLY_ID AS REPLY_ID,
       REPLY.WRITER_ID AS WRITER_ID,
       REPLY.CONTENTS AS CONTENTS,
       TO_CHAR(REPLY.CREATED_DATE, 'yyyy-mm-dd') AS CREATED_DATE
FROM USED_GOODS_BOARD BOARD INNER JOIN USED_GOODS_REPLY REPLY
    ON BOARD.BOARD_ID = REPLY.BOARD_ID
WHERE TO_CHAR(BOARD.CREATED_DATE, 'yyyy-mm') LIKE '2022-10'
ORDER BY REPLY.CREATED_DATE ASC, BOARD.TITLE ASC;

SELECT BOARD.TITLE AS TITLE,
       BOARD.BOARD_ID AS BOARD_ID,
       REPLY.REPLY_ID AS REPLY_ID,
       REPLY.WRITER_ID AS WRITER_ID,
       REPLY.CONTENTS AS CONTENTS,
       TO_CHAR(REPLY.CREATED_DATE, 'yyyy-mm-dd') AS CREATED_DATE
FROM USED_GOODS_BOARD BOARD, USED_GOODS_REPLY REPLY
WHERE BOARD.BOARD_ID = REPLY.BOARD_ID
  AND TO_CHAR(BOARD.CREATED_DATE, 'yyyy-mm') LIKE '2022-10'
ORDER BY REPLY.CREATED_DATE ASC, BOARD.TITLE ASC;