package com.uracle.sample.api.walking.mapper;

import java.util.List;

import com.uracle.sample.api.walking.table.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    /*################## Users #####################*/
    Integer createUser(Users user);
    Users selectUserById(Users user);
    List<Users> selectUser();
    Integer editUser(Users user);
    Integer deleteUser(Users user);
}
