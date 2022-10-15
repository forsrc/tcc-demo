
DROP TABLE IF EXISTS t_order;

CREATE TABLE t_order
(
    id        bigint        NOT NULL,
    user_id   bigint        NOT NULL,
    money     decimal(10,2) NOT NULL,
    enabled   tinyint(1)    NOT NULL DEFAULT 0,
    version   int           NOT NULL DEFAULT 0,
    create_on TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_on TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (username),
    INDEX       i_order_username (username)
); -- ENGINE=InnoDB DEFAULT CHARSET=latin1;
