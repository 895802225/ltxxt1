package com.test.dao;

import com.test.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
//    查找人员代码返回数据
    List<User> listUser(String code);
}