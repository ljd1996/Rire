package com.hearing.rire.service;

import com.hearing.rire.bean.Order;
import com.hearing.rire.bean.OrderExample;
import com.hearing.rire.dao.OrderMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hearing on 19-4-16
 */

@Service
public class OrderServices {

    @Autowired
    private OrderMapper orderMapper;

    public Msg addOrder(Order order) {
        return Msg.response(orderMapper.insert(order) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public List<Order> getMyOrder(int userId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserBuyerIdEqualTo(userId);
        return orderMapper.selectByExample(example);
    }
}
