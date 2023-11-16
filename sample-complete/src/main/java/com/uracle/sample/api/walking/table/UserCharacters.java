package com.uracle.sample.api.walking.table;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class UserCharacters {
    private int user_char_id;
    private String phone_number;
    private int exp;
    private String character_info;
    private String character_nickname;
    private LocalDateTime acquisition_date;
    private boolean is_active;
}
