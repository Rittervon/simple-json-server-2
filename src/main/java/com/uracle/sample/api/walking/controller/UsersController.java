package com.uracle.sample.api.walking.controller;

import com.uracle.sample.api.walking.service.UsersService;
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
@RequestMapping("/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/insert")
    public ResponseEntity<MspResult> createUser(@RequestBody Users param) {
        MspResult result;

        int affectRow = usersService.createUser(param);

        if (affectRow > 0) {
            result = makeResult(param);
        } else {
            result = makeResult("9999", "등록 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<MspResult> selectUser() {
        MspResult result;

        List<Users> body = usersService.selectUser();

        if (body.size() > 0) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{phone_number}")
    public ResponseEntity<MspResult> selectUserById(@PathVariable("phone_number") String id) {
        MspResult result;

        Users param = new Users();
        param.setPhone_number(id);
        Users body = usersService.selectUserById(param);

        if (body != null) {
            result = makeResult(body);
        } else {
            result = makeResult("8888", "등록된 사용자가 없음", body);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{phone_number}")
    public ResponseEntity<MspResult> editUser(@PathVariable("phone_number") String id, @RequestBody Users param) {
        MspResult result;

        param.setPhone_number(id);
        int affectRow = usersService.editUser(param);

        if (affectRow == 1) {
            result = makeResult(param);
        } else if(affectRow > 1) {
            result = makeResult("4444", "복수 개의 사용자가 수정됨, 시스템 점검 바람", param);
        } else {
            result = makeResult("4444", "수정할 사용자가 없거나, 파라미터 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/delete/{phone_number}")
    public ResponseEntity<MspResult> deleteUser(@PathVariable("phone_number") String id) {
        MspResult result;

        Users param = new Users();
        param.setPhone_number(id);
        int affectRow = usersService.deleteUser(param);

        if (affectRow == 1) {
            result = makeResult(param);
        } else {
            result = makeResult("4444", "삭제할 사용자가 없거나, 파라미터 오류", param);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
