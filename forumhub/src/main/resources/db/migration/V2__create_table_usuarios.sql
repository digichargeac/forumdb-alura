CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          login VARCHAR(100) UNIQUE NOT NULL,
                          senha VARCHAR(255) NOT NULL
);