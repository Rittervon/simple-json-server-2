package com.uracle.sample.api.walking.service;

import com.uracle.sample.api.walking.mapper.UserStationsMapper;
import com.uracle.sample.api.walking.table.UserStations;
import com.uracle.sample.api.walking.table.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class UserStationsService {
    @Autowired
    private UserStationsMapper userStationsMapper;

    public int insertUserStation(UserStations userStation){
        int affectRow = userStationsMapper.insertUserStation(userStation);
        logger.debug("insert count: {}", affectRow);

        return affectRow;
    }

    public UserStations selectUserStation(UserStations param) {
        UserStations userStation = userStationsMapper.selectUserStation(param);
        if (userStation == null) {
            userStation = new UserStations();
        }
        logger.debug("userStation: {}", userStation);

        return userStation;
    }
    public int clearUserStation(UserStations param) {
        int affectRow = userStationsMapper.clearUserStation(param);
        logger.debug("delete count: {}", affectRow);

        return affectRow;
    }
}
