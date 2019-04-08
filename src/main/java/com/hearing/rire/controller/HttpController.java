package com.hearing.rire.controller;

import com.hearing.rire.bean.User;
import com.hearing.rire.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by hearing on 19-4-8
 */
@RestController
public class HttpController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index() {
        User user = new User();
        user.setName("rire");
        user.setAddress("华中科技大学");
        user.setCompany("hhh");
        user.setPhone("15927382214");
        user.setType(0);
        userMapper.insert(user);
//        UserExample example = new UserExample();
//        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(2);
//        List<User> users = userMapper.selectByExample(example);
//
//        return users.get(0).getAddress() + users.get(0).getName();
        return "rire";
    }
}
