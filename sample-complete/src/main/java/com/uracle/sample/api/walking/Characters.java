package com.uracle.sample.api.walking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Characters {
    private int char_id;
    private String character_info;
    private int required_points;
}
