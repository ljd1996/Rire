package com.hearing.rire.service;

import com.hearing.rire.bean.User;
import com.hearing.rire.bean.UserExample;
import com.hearing.rire.dao.UserMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hearing on 19-4-9
 */
@Service
public class UserServices {

    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public Msg register(User user) {
        if (userMapper.insert(user) >= 0) {
            return Msg.response(Msg.CODE_SUCCESS);
        } else {
            return Msg.response(Msg.CODE_FAIL);
        }
    }

    public Msg login(String name, String password) {
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
