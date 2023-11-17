package com.uracle.sample.api.walking.service;

import com.uracle.sample.api.walking.mapper.UserStationsMapper;
import com.uracle.sample.api.walking.table.UserStations;
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

    public List<UserStations> selectUserStation() {
        List<UserStations> userStations = userStationsMapper.selectUserStation();
        logger.debug("select count: {}", userStations.size());

        for (UserStations userStation : userStations) {
            logger.debug(">>>> userStation: {}", userStation);
        }

        return userStations;
    }

    public int clearUserStation(UserStations param) {
        int affectRow = userStationsMapper.clearUserStation(param);
        logger.debug("delete count: {}", affectRow);

        return affectRow;
    }
}
