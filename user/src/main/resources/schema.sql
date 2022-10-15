
DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user
(
    id        bigint       NOT NULL,
    username  varchar(50)  NOT NULL,
    password  varchar(200) NOT NULL,
    enabled   tinyint(1)   NOT NULL DEFAULT 0,
    version   int          NOT NULL DEFAULT 0,
    status    tinyint(2)   NOT NULL DEFAULT 0,
    create_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE  KEY uk_user_username (username),
    INDEX i_user_username (username)
); -- ENGINE=InnoDB DEFAULT CHARSET=latin1;
