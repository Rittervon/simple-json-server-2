package com.uracle.sample.api.walking.service;

import java.util.List;

import com.uracle.sample.api.walking.table.Users;
import com.uracle.sample.api.walking.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public int createUser(Users user){
        int affectRow = usersMapper.createUser(user);
        logger.debug("insert count: {}", affectRow);

        return affectRow;
    }

    public List<Users> selectUser() {
        List<Users> users = usersMapper.selectUser();
        logger.debug("select count: {}", users.size());

        for (Users user : users) {
            logger.debug(">>>> user: {}", user);
        }

        return users;
    }

    public Users selectUserById(Users param) {
        Users user = usersMapper.selectUserById(param);
        if (user == null) {
            user = new Users();
        }
        logger.debug("user: {}", user);

        return user;
    }

    public int editUser(Users param) {
        int affectRow = usersMapper.editUser(param);
        logger.debug("update count: {}", affectRow);

        return affectRow;
    }

    public int deleteUser(Users param) {
        int affectRow = usersMapper.deleteUser(param);
        logger.debug("delete count: {}", affectRow);

        return affectRow;
    }
}
