package com.uracle.sample.api.walking.table;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class UserStations {
    private int user_station_id;
    private String phone_number;
    private float latitude;
    private float longitude;
    private LocalDateTime visit_date;
}
