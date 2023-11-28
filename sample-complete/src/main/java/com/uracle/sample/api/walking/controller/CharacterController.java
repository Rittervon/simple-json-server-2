package com.uracle.sample.api.walking.controller;

import com.uracle.sample.api.walking.service.CharactersService;
import com.uracle.sample.api.walking.table.Characters;
import com.uracle.sample.api.walking.table.Users;
import com.uracle.sample.support.annotation.MSP;
import com.uracle.sample.support.result.MspResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.uracle.sample.support.MspUtil.makeResult;

@MSP
@Slf4j
@RestController
@RequestMapping("/chars")
@CrossOrigin(origins = "https://happywalking.web.app")
public class CharacterController {

    @Autowired
    private CharactersService charactersService;

    @GetMapping("")
    public ResponseEntity<MspResult> selectCharacter() {
        MspResult result;

        List<Characters> body = charactersService.selectCharacter();

        if (body.size() > 0) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{char_id}")
    public ResponseEntity<MspResult> selectCharacterById(@PathVariable("char_id") int id) {
        MspResult result;

        Characters param = new Characters();
        param.setChar_id(id);
        Characters body = charactersService.selectCharacterById(param);

        if (body != null) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
