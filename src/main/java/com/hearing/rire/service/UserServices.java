package com.hearing.rire.service;

import com.hearing.rire.bean.User;
import com.hearing.rire.bean.UserExample;
import com.hearing.rire.dao.UserMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by hearing on 19-4-9
 */
public class UserServices {

    @Autowired
    private UserMapper userMapper;

    private Msg register(User user) {
        if (userMapper.insert(user) >= 0) {
            return Msg.response(Msg.CODE_SUCCESS);
        } else {
            return Msg.response(Msg.CODE_FAIL);
        }
    }

    private Msg login(String name, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name).andPasswordEqualTo(password);
        if (userMapper.selectByExample(userExample).size() > 0) {
            return Msg.response(Msg.CODE_SUCCESS);
        } else {
            return Msg.response(Msg.CODE_FAIL);
        }
    }
}
