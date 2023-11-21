package com.uracle.sample.api.walking.service;

import com.uracle.sample.api.walking.mapper.CharactersMapper;
import com.uracle.sample.api.walking.table.Characters;
import com.uracle.sample.api.walking.table.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class CharactersService {
    @Autowired
    private CharactersMapper charactersMapper;

    public List<Characters> selectCharacter() {
        List<Characters> characters = charactersMapper.selectCharacter();
        logger.debug("select count: {}", characters.size());

        for (Characters character : characters) {
            logger.debug(">>>> character: {}", character);
        }

        return characters;
    }

    public Characters selectCharacterById(Characters param) {
        Characters character = charactersMapper.selectCharacterById(param);
        if (character == null) {
            character = new Characters();
        }
        logger.debug("character: {}", character);

        return character;
    }
}
