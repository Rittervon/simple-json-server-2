package com.uracle.sample.api.walking;

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
    private int experience_box;
    private String character_info;
    private LocalDateTime acquisition_date;
}
