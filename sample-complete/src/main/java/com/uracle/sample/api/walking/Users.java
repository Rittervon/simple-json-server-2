package com.uracle.sample.api.walking;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Users {
    private String phone_number;
    private String name;
    private LocalDateTime registration_date;
}
