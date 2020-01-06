DROP TABLE IF EXISTS EXCHANGE_RATE_HISTORY;

CREATE TABLE EXCHANGE_RATE_HISTORY

(
    id                 SERIAL PRIMARY KEY,

    currency_code_from varchar(100) NOT NULL,

    currency_code_to   varchar(100) NOT NULL,

    exchange_rate      varchar(100) NOT NULL,

    last_refreshed     varchar(100) NOT NULL,

    bid_price          varchar(100) NOT NULL,

    ask_price          varchar(100) NOT NULL

);