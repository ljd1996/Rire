package com.hearing.rire.service;

import com.hearing.rire.bean.User;
import com.hearing.rire.bean.UserExample;
import com.hearing.rire.dao.UserMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hearing on 19-4-9
 */
@Service
public class UserServices {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof UserDetails ? (User) principal : null;
    }

    /**
     * 根据用户名获取用户
     *
     * @param name
     * @return
     */
    public User getUserByName(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() > 0 ? users.get(0) : null;
    }

    /**
     * 根据primary id获取用户
     *
     * @param id
     * @return
     */
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据name模糊查找用户
     *
     * @param name
     * @return
     */
    public List<User> searchUser(String name) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andNameLike("%" + name + "%");
        return userMapper.selectByExample(userExample);
    }

    /**
     * 更新用户信息
     */
    public Msg update(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(getCurrentUser().getId());
        return Msg.response(userMapper.updateByExampleSelective(user, userExample) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Msg register(User user) throws Exception {
        return Msg.response(userMapper.insert(user) > 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 登录(没用到)
     *
     * @param name
     * @param password
     * @return
     */
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
