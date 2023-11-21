package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.UserStations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserStationsMapper {

    /*################## UserStations #####################*/
    Integer insertUserStation(UserStations userStation);
    List<UserStations> selectUserStation();
    Integer clearUserStation(UserStations userStation);
}
