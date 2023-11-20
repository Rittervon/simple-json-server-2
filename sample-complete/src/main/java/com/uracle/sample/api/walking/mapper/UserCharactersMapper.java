package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.UserCharacters;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCharactersMapper {

    /*################## UserCharacters #####################*/
    Integer getCharacter(UserCharacters userCharacter);
    List<UserCharacters> selectUserCharacter();

    UserCharacters selectCharacterById(UserCharacters userCharacter);
    Integer updateCharacter(UserCharacters userCharacter);
}
