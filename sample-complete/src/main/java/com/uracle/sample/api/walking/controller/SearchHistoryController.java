package com.uracle.sample.api.walking.controller;

import com.uracle.sample.api.walking.service.SearchHistoryService;
import com.uracle.sample.api.walking.service.UsersService;
import com.uracle.sample.api.walking.table.SearchHistory;
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
@RequestMapping("/histo")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @PostMapping("")
    public ResponseEntity<MspResult> insertSearchHistory(@RequestBody SearchHistory param) {
        MspResult result;

        int affectRow = searchHistoryService.insertSearchHistory(param);

        if (affectRow > 0) {
            result = makeResult(param);
        } else {
            result = makeResult("9999", "등록 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<MspResult> selectSearchHistory() {
        MspResult result;

        List<SearchHistory> body = searchHistoryService.selectSearchHistory();

        if (body.size() > 0) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete/{history_id}")
    public ResponseEntity<MspResult> deleteSearchHistory(@PathVariable("history_id") int id) {
        MspResult result;

        SearchHistory param = new SearchHistory();
        param.setHistory_id(id);
        int affectRow = searchHistoryService.deleteSearchHistory(param);

        if (affectRow == 1) {
            result = makeResult(param);
        } else {
            result = makeResult("4444", "삭제할 사용자가 없거나, 파라미터 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
