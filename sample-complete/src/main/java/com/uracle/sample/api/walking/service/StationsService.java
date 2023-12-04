package com.uracle.sample.api.walking.service;

import com.uracle.sample.api.walking.mapper.StationsMapper;
import com.uracle.sample.api.walking.table.Stations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class StationsService {
    @Autowired
    private StationsMapper stationsMapper;
    public List<Stations> selectStatioin() {
        List<Stations> stations = stationsMapper.selectStatioin();
        logger.debug("select count: {}", stations.size());

        for (Stations station : stations) {
            logger.debug(">>>> user: {}", station);
        }

        return stations;
    }

}
