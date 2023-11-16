package com.uracle.sample.api.walking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Stations {
    private float latitude;
    private float longitude;
    private int points;
    private String description;
}
