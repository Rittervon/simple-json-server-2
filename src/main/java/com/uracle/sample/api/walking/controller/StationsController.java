package com.uracle.sample.api.walking.controller;


import com.uracle.sample.api.walking.service.StationsService;
import com.uracle.sample.api.walking.table.Stations;
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
@RequestMapping("/stations")
@CrossOrigin(origins = "https://happywalking.web.app")
public class StationsController {
    @Autowired
    private StationsService stationsService;

    @GetMapping("")
    public ResponseEntity<MspResult> selectStatioin() {
        MspResult result;

        List<Stations> body = stationsService.selectStatioin();

        if (body.size() > 0) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
