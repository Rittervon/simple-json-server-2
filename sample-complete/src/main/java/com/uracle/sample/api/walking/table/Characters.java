package com.uracle.sample.api.walking.table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Characters {
    private int char_id;
    private String character_info;
    private String character_name;
    private int required_points;
    private String img_url;
}
