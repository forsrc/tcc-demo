-- user
INSERT INTO t_user (id, username, password, enabled)
SELECT *
FROM 
(
    SELECT 1 id, 'forsrc' username, '$2a$10$Wzme7qZtAsJZspQpNx3ee.qTu/IqRHiTb0jORWUOXCxptAkG3kf8e' password, 1 enabled
    WHERE NOT EXISTS(SELECT username FROM t_user WHERE username = 'forsrc')
)
;

INSERT INTO t_balance (id, user_id, balance, enabled)
SELECT *
FROM 
(
    SELECT 1 id, 1 user_id, 100.00 balance, 1 enabled
    WHERE NOT EXISTS(SELECT id FROM t_balance WHERE id = 1)
)
;


