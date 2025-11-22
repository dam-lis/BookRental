CREATE TABLE IF NOT EXISTS identities(
    identity_id         VARCHAR(36)     NOT NULL,
    identity_status     VARCHAR(20)     NOT NULL,
    email_value         VARCHAR(100)    NOT NULL,
    password            VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_identities PRIMARY KEY (identity_id)
);