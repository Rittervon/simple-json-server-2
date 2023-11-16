package com.uracle.sample.api.walking.controller;


import com.uracle.sample.api.walking.service.StationsService;
import com.uracle.sample.api.walking.table.Stations;
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
public class StationsController {
    @Autowired
    private StationsService stationsService;

    @PostMapping("")
    public ResponseEntity<MspResult> initStation(@RequestBody Stations param) {
        MspResult result;

        int affectRow = stationsService.initStation(param);

        if (affectRow > 0) {
            result = makeResult(param);
        } else {
            result = makeResult("9999", "등록 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
