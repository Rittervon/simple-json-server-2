package com.uracle.sample.api.sample;

import static com.uracle.sample.support.MspUtil.makeResult;

import com.uracle.sample.support.annotation.MSP;
import com.uracle.sample.support.result.MspResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MSP
@Slf4j
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @PostMapping("")
    public ResponseEntity<MspResult> insertSample(@RequestBody Sample param) {
        MspResult result;

        int affectRow = sampleService.insertSample(param);

        if (affectRow > 0) {
            result = makeResult(param);
        } else {
            result = makeResult("9999", "등록 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<MspResult> getSamples() {
        MspResult result;

        List<Sample> body = sampleService.selectSamples();

        if (body.size() > 0) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MspResult> getSampleById(@PathVariable("id") String id) {
        MspResult result;

        Sample param = new Sample();
        param.setId(id);
        Sample body = sampleService.selectSampleById(param);

        if (body != null) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity<MspResult> updateSample(@PathVariable("id") String id, @RequestBody Sample param) {
        MspResult result;

        param.setId(id);
        int affectRow = sampleService.updateSample(param);

        if (affectRow == 1) {
            result = makeResult(param);
        } else if(affectRow > 1) {
            result = makeResult("4444", "복수 개의 사용자가 수정됨, 시스템 점검 바람", param);
        } else {
            result = makeResult("4444", "수정할 사용자가 없거나, 파라미터 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<MspResult> deleteSample(@PathVariable("id") String id) {
        MspResult result;

        Sample param = new Sample();
        param.setId(id);
        int affectRow = sampleService.deleteSample(param);

        if (affectRow == 1) {
            result = makeResult(param);
        } else {
            result = makeResult("4444", "삭제할 사용자가 없거나, 파라미터 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
