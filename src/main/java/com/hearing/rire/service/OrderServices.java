package com.hearing.rire.service;

import com.hearing.rire.bean.Order;
import com.hearing.rire.bean.OrderExample;
import com.hearing.rire.bean.Product;
import com.hearing.rire.dao.OrderMapper;
import com.hearing.rire.dao.ProductMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by hearing on 19-4-16
 */

@Service
public class OrderServices {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    public Msg addOrder(Order order) {
        return Msg.response(orderMapper.insert(order) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public Order getOrder(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public List<Order> getMyOrder(int userId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserBuyerIdEqualTo(userId);
        OrderExample.Criteria criteria1 = example.createCriteria();
        criteria1.andUserSupplierIdEqualTo(userId);
        example.or(criteria1);
        return orderMapper.selectByExample(example);
    }

    public List<Product> getProductsByOrders(List<Order> orders) {
        List<Product> products = new ArrayList<>();
        for (Order order:orders) {
            Product product = productMapper.selectByPrimaryKey(order.getProSupplierId());
            products.add(product);
        }
        return products;
    }
}
