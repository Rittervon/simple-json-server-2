DROP TABLE IF EXISTS user_stations;
DROP TABLE IF EXISTS stations;
DROP TABLE IF EXISTS search_history;
DROP TABLE IF EXISTS background_task_logs;
DROP TABLE IF EXISTS user_achievements;
ALTER TABLE users
DROP
CONSTRAINT IF EXISTS user_char_id;
ALTER TABLE users
DROP
COLUMN IF EXISTS user_char_id;
DROP TABLE IF EXISTS user_characters;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS users;

-- 사용자 테이블 생성
CREATE TABLE users
(
    phone_number      character varying(255) NOT NULL UNIQUE,
    name_or_id        character varying(255) NOT NULL,
    user_char_id      bigint,
    registration_date timestamp(6)           NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

-- 캐릭터 정보 테이블
CREATE TABLE characters
(
    char_id         bigint(64) auto_increment PRIMARY KEY,
    character_info  text,
    character_name  text,
    required_points int,
    img_url         character varying(255)
);

-- 캐릭터 테이블
CREATE TABLE user_characters
(
    user_char_id       bigint AUTO_INCREMENT PRIMARY KEY,
    char_id            bigint,
    phone_number       character varying(255),
    exp                int,
    character_info     character varying(1024),
    character_nickname character varying(255),
    acquisition_date   timestamp DEFAULT CURRENT_TIMESTAMP(),
    img_url            character varying(255),
    is_active          boolean,
    FOREIGN KEY (char_id) REFERENCES characters (char_id),
    FOREIGN KEY (phone_number) REFERENCES users (phone_number)
);

ALTER TABLE users
    ADD CONSTRAINT user_char_id
        FOREIGN KEY (user_char_id)
            REFERENCES user_characters (user_char_id);


-- 산책지점 테이블
CREATE TABLE stations
(
    latitude DOUBLE,
    longitude DOUBLE,
    place_name VARCHAR(255),
    points     INT,
    PRIMARY KEY (latitude, longitude)
);

-- 사용자 산책지점 방문 기록 테이블   (3일에 한번 초기화 됨)
CREATE TABLE user_stations
(
    user_station_id INT AUTO_INCREMENT PRIMARY KEY,
    phone_number    VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE,
    place_name      VARCHAR(255),
    visit_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    CONSTRAINT location FOREIGN KEY (latitude, longitude) REFERENCES stations (latitude, longitude),
    FOREIGN KEY (phone_number) REFERENCES users (phone_number)
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

-- INSERT INTO user_characters (phone_number, exp, char_id, character_info, character_nickname, img_url, is_active)
-- VALUES ('010-0000-0000', 0, 1, 'test1', 'c1', 'https://drive.google.com/uc?export=view&id=1D6R19DZmGZAH86X_Qc4ygNT73gfqO7th', false),
--        ('010-0000-0000', 0, 2, 'test2', 'c2', 'https://drive.google.com/uc?export=view&id=1Ql8HiX4gXQU1vICkiSF-4hJoEg9wpCwn', true);

INSERT INTO user_characters (char_id, character_info, character_nickname, img_url, phone_number, exp, is_active)
SELECT char_id, character_info, character_name, img_url, '010-0000-0000', 100, true
FROM characters
where char_id = 1;
INSERT INTO user_characters (char_id, character_info, character_nickname, img_url, phone_number, exp, is_active)
SELECT char_id, character_info, character_name, img_url, '010-0000-0000', 200, false
FROM characters
where char_id = 2;
INSERT INTO user_characters (char_id, character_info, character_nickname, img_url, phone_number, exp, is_active)
SELECT char_id, character_info, character_name, img_url, '010-0000-0000', 300, false
FROM characters
where char_id = 3;
INSERT INTO user_characters (char_id, character_info, character_nickname, img_url, phone_number, exp, is_active)
SELECT char_id, character_info, character_name, img_url, '010-0000-0000', 400, false
FROM characters
where char_id = 4;

INSERT INTO stations (latitude, longitude, points, place_name)
VALUES (35.9083169000378, 128.8000559439628, 100, '세븐일레븐 경일대점'),      -- 학교 식당
       (35.910028826785364, 128.80051841346608, 100, '세븐일레븐 경일대공대점'), --
       (35.90711447627247, 128.8024211700401, 100, '세븐일레븐 경일대구내점'),   -- 18호관안
       (35.90383688436267, 128.80075744863962, 100, 'GS25 경일대정문점'),   -- 학교 앞 GS
       (35.90392406965374, 128.8005019121349, 100, 'CU 경일대정문점'),      -- 학교 앞 CU
       (35.90186850459353, 128.8013219973928, 100, 'GS25 호산대정문점'),    -- 호산대 앞
       (35.901181686682406, 128.80010197841105, 100, 'CU 호산대학교점'),    -- 호산대 평생교육원
       (35.90898774558578, 128.80743424422423, 100, 'GS25 대가대기숙사점'),  -- 대구대 기숙사 앞
       (35.91177820828526, 128.80673342657622, 100, 'CU 대가대교양관점'),    -- 대구대 우편
       (35.90796020918426, 128.81193555412446, 100, 'CU 대가대정문점'); -- 대구대 앞

INSERT INTO user_stations (phone_number, latitude, longitude, place_name)
VALUES ('010-0000-0000', 35.910028826785364, 128.80051841346608, '세븐일레븐 경일대공대점'), -- 세븐일레븐 경일대공대점
       ('010-0000-0000', 35.9083169000378, 128.8000559439628, '세븐일레븐 경일대점'),   -- 세븐일레븐 경일대점
       ('010-0000-0000', 35.90711447627247, 128.8024211700401, '세븐일레븐 경일대구내점'),  -- 세븐일레븐 경일대구내점
       ('010-0000-0000', 35.90383688436267, 128.80075744863962, 'GS25 경일대정문점'), -- GS25 경일대정문점
       ('010-0000-0000', 35.90392406965374, 128.8005019121349, 'CU 경일대정문점'); -- CU 경일대정문점


UPDATE users
SET user_char_id = (SELECT user_char_id
                    FROM user_characters
                    WHERE is_active = TRUE)
WHERE phone_number = '010-0000-0000';


commit;

-- select *
-- from users;
--
-- SELECT user_characters.img_url
-- FROM users
--          JOIN user_characters
--               ON users.user_char_id = user_characters.user_char_id
-- WHERE users.phone_number = '010-0000-0000';
--
-- SELECT *
-- FROM user_characters
-- WHERE user_char_id = (
--     SELECT user_char_id
--     FROM users
--     WHERE phone_number = '010-0000-0000'
--     );

SELECT characters.char_id
FROM characters
         JOIN user_characters
              ON characters.char_id = user_characters.char_id;

select *
from user_stations;


