DROP TABLE IF EXISTS user_stations;
DROP TABLE IF EXISTS stations;
DROP TABLE IF EXISTS user_characters;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS search_history;
DROP TABLE IF EXISTS background_task_logs;
DROP TABLE IF EXISTS user_achievements;
DROP TABLE IF EXISTS user_background_states;
DROP TABLE IF EXISTS users;

-- 사용자 테이블 생성
CREATE TABLE users
(
    phone_number      character varying(255) NOT NULL UNIQUE,
    name_or_id        character varying(255) NOT NULL,
    registration_date timestamp(6)           NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

-- 캐릭터 테이블
CREATE TABLE user_characters
(
    user_char_id        bigint AUTO_INCREMENT PRIMARY KEY,
    phone_number        character varying(255),
    exp                 int,
    character_info      character varying(1024),
    character_nickname  character varying(255),
    acquisition_date    timestamp,
    is_active           boolean,
    FOREIGN KEY (phone_number) REFERENCES users (phone_number)
);

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
    CONSTRAINT location_PK PRIMARY KEY (latitude, longitude)
);

-- 사용자 산책지점 방문 기록 테이블   (3일에 한번 초기화 됨)
CREATE TABLE user_stations
(
    user_station_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number    VARCHAR(255),
    latitude        DOUBLE,
    longitude       DOUBLE,
    visit_date      TIMESTAMP,
    FOREIGN KEY (latitude, longitude) REFERENCES stations(latitude, longitude),
    FOREIGN KEY (phone_number) REFERENCES users(phone_number)
);

-- 검색 이력 테이블
CREATE TABLE search_history
(
    history_id   bigint(64) auto_increment PRIMARY KEY,
    phone_number character varying(255),
    search_term  character varying(255),
    search_date  timestamp(6),
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

INSERT INTO characters (character_info, character_name, required_points, img_url)
VALUES ('test1', 'c1', 0, 'https://drive.google.com/uc?export=view&id=1jsGm1TAdafvJ8jJIK_yBuh-QVtA64pxb'),
       ('test2', 'c2', 0, 'https://drive.google.com/uc?export=view&id=1rPwp8J5dzrjq7kbfyqOgKQRbbcX7BxgO'),
       ('test3', 'c3', 0, 'https://drive.google.com/uc?export=view&id=1lZ6Jr5hgNGFck0qr7b6Ykp7gUk_Dv2Zz'),
       ('test4', 'c4', 0, 'https://drive.google.com/uc?export=view&id=1Xhi9JBcmXplEaRpVLFPW7OtmDHMJdV-N'),
       ('test5', 'c5', 0, 'https://drive.google.com/uc?export=view&id=1mVACW9_e-rZE8mDsA5gnxp7tNNM8PBZy');