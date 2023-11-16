package com.uracle.sample.api.walking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalkingMapper {

    /*################## Users #####################*/
    Integer createUser(Users user);
    Users selectUserById(Users user);
    List<Users> selectUser();
    Integer updateUser(Users user);
    Integer deleteUser(Users user);


    /*################## Characters #####################*/
    List<Characters> selectCharacter();


    /*################## UserCharacters #####################*/
    Integer getCharacter(UserCharacters userCharacter);
    List<UserCharacters> selectUserCharacter();
    Integer updateCharacter(UserCharacters userCharacter);


    /*################## Stations #####################*/
    Integer initStation(Stations station);
    List<Stations> selectStatioin();
    Integer deleteStatioin(Stations station);


    /*################## UserStations #####################*/
    Integer insertUserStation(UserStations userStation);
    List<UserStations> selectUserStatioin();
    Integer clearUserStatioin(UserStations userStation);


    /*################## SearchHistory #####################*/
    Integer insertSearchHistory(SearchHistory searchHistory);
    List<SearchHistory> selectSearchHistory();
    Integer deleteSearchHistory(SearchHistory searchHistory);

}
