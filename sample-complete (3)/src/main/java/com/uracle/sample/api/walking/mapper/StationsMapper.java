package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.Stations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StationsMapper {

    /*################## Stations #####################*/
    Integer initStation(Stations station);
    List<Stations> selectStatioin();
    Integer deleteStatioin(Stations station);
}
