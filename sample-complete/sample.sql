DROP TABLE IF EXISTS user_stations;
DROP TABLE IF EXISTS stations;
DROP TABLE IF EXISTS user_background_states;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS search_history;
DROP TABLE IF EXISTS background_task_logs;
DROP TABLE IF EXISTS user_achievements;
ALTER TABLE users
    DROP CONSTRAINT IF EXISTS user_char_id;
ALTER TABLE users
    DROP COLUMN IF EXISTS user_char_id;
DROP TABLE IF EXISTS user_characters;
DROP TABLE IF EXISTS users;

-- 사용자 테이블 생성
CREATE TABLE users
(
    phone_number        character varying(255) NOT NULL UNIQUE,
    name_or_id          character varying(255) NOT NULL,
    user_char_id        bigint,
    registration_date   timestamp(6)           NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

-- 캐릭터 테이블
CREATE TABLE user_characters
(
    user_char_id        bigint AUTO_INCREMENT PRIMARY KEY,
    phone_number        character varying(255),
    exp                 int,
    character_info      character varying(1024),
    character_nickname  character varying(255),
    acquisition_date    timestamp DEFAULT CURRENT_TIMESTAMP(),
    img_url         character varying(255),
    is_active           boolean,
    FOREIGN KEY (phone_number) REFERENCES users (phone_number)
);

ALTER TABLE users
    ADD CONSTRAINT user_char_id
    FOREIGN KEY (user_char_id)
    REFERENCES user_characters (user_char_id);

-- 캐릭터 정보 테이블
CREATE TABLE characters
(
    char_id         bigint(64)  auto_increment  PRIMARY KEY,
    character_info  text,
    character_name  text,
    required_points int,
    img_url         character varying(255)
);

-- 산책지점 테이블
CREATE TABLE stations
(
    latitude  DOUBLE,
    longitude DOUBLE,
    points    INT,
    PRIMARY KEY (latitude, longitude)
);

-- 사용자 산책지점 방문 기록 테이블   (3일에 한번 초기화 됨)
CREATE TABLE user_stations
(
    user_station_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number    VARCHAR(255),
    latitude        DOUBLE,
    longitude       DOUBLE,
    visit_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (latitude, longitude) REFERENCES stations(latitude, longitude),
    FOREIGN KEY (phone_number) REFERENCES users(phone_number)
);

-- 검색 이력 테이블
CREATE TABLE search_history
(
    history_id   bigint(64) auto_increment PRIMARY KEY,
    phone_number character varying(255),
    search_term  character varying(255),
    search_date  timestamp(6) DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (phone_number) REFERENCES users (phone_number)
);

-- -- 백그라운드 작업 로그 테이블
-- CREATE TABLE background_task_logs
-- (
--     task_id      bigint(64) auto_increment PRIMARY KEY,
--     phone_number character varying(255),
--     task_type    character varying(255),
--     task_status  character varying(255),
--     start_time   timestamp(6),
--     end_time     timestamp(6),
--     FOREIGN KEY (phone_number) REFERENCES users (phone_number)
-- );

-- -- 사용자 업적 테이블
-- CREATE TABLE user_achievements
-- (
--     achievement_id   bigint(64) auto_increment PRIMARY KEY,
--     phone_number     character varying(255),
--     achievement_name character varying(255),
--     achievement_date timestamp(6),
--     FOREIGN KEY (phone_number) REFERENCES users (phone_number)
-- );

-- -- 사용자 백그라운드 상태 테이블
-- CREATE TABLE user_background_states
-- (
--     state_id     bigint(64) auto_increment PRIMARY KEY,
--     phone_number character varying(255),
--     state        character varying(255),
--     state_date   timestamp(6),
--     FOREIGN KEY (phone_number) REFERENCES users (phone_number)
-- );

INSERT INTO users (phone_number, name_or_id)
VALUES ('010-0000-0000', 'user01');

INSERT INTO characters (character_info, character_name, required_points, img_url)
VALUES ('test1', 'c1', 0, 'https://drive.google.com/uc?export=view&id=1D6R19DZmGZAH86X_Qc4ygNT73gfqO7th'),
       ('test2', 'c2', 0, 'https://drive.google.com/uc?export=view&id=1Ql8HiX4gXQU1vICkiSF-4hJoEg9wpCwn'),
       ('test3', 'c3', 0, 'https://drive.google.com/uc?export=view&id=1qNSnDLT9BJD2tceLRzHbBX536KZevnn_'),
       ('test4', 'c4', 0, 'https://drive.google.com/uc?export=view&id=1koTVy87I9_thCsg-Mq1bRf-U5QS6yfWW'),
       ('test5', 'c5', 0, 'https://drive.google.com/uc?export=view&id=1mVACW9_e-rZE8mDsA5gnxp7tNNM8PBZy');

INSERT INTO user_characters (phone_number, exp, character_info, character_nickname, img_url, is_active)
VALUES ('010-0000-0000', 0, 'test1', 'c1', 'https://drive.google.com/uc?export=view&id=1D6R19DZmGZAH86X_Qc4ygNT73gfqO7th', true);

UPDATE users
SET user_char_id = (
    SELECT user_char_id
    FROM user_characters
    WHERE is_active = TRUE
    )
WHERE phone_number = '010-0000-0000';


commit;

select *
from users
