CREATE TABLE credit_products_db.LOAN_APPLICATION (
    LOAN_ID VARCHAR(200) NOT NULL,
    USER_ID VARCHAR(200) NOT NULL,
    CREATED_TIME TIMESTAMP NOT NULL,
    UPDATED_TIME TIMESTAMP NOT NULL,
    constraint LOAN_ID_PK primary key (LOAN_ID)
 );