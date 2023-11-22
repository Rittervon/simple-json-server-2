package com.uracle.sample.api.walking.table;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Users {
    private String phone_number;
    private String name_or_id;
    private int user_char_id;
    private LocalDateTime registration_date;
}
