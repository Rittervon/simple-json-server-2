package com.uracle.sample.api.walking;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class SearchHistory {
    private int history_id;
    private String phone_number;
    private String search_term;
    private LocalDateTime search_date;
}
