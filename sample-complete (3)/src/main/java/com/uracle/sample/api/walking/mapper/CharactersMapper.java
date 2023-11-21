package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.Characters;
import com.uracle.sample.api.walking.table.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharactersMapper {

    /*################## Characters #####################*/
    List<Characters> selectCharacter();
    Characters selectCharacterById(Characters character);
}
