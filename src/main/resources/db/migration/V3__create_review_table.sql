CREATE TABLE REVIEW
(
    REVIEW_ID              BIGSERIAL PRIMARY KEY,
    TEXT                   VARCHAR(256) NOT NULL,
    RATING                 NUMBER       NOT NULL,
    APPLICATION_USER_ID_FK BIGINT       NOT NULL,
    CONSTRAINT APPLICATION_USER_ID_FK FOREIGN KEY (APPLICATION_USER_ID_FK)
        REFERENCES APPLICATION_USER (APPLICATION_USER_ID)
);
