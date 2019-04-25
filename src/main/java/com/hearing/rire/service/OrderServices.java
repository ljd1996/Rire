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

    /**
     * 添加订单
     * @param order
     * @return
     */
    public Msg addOrder(Order order) {
        return Msg.response(orderMapper.insertAndGetId(order) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL)
                .add("orderId", order.getId());
    }

    /**
     * 根据primary id获取订单
     * @param id
     * @return
     */
    public Order getOrder(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    public Msg deleteOrder(int id) {
        return Msg.response(orderMapper.deleteByPrimaryKey(id) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 获取某一用户的订单
     * @param userId
     * @return
     */
    public List<Order> getMyOrder(int userId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserBuyerIdEqualTo(userId);
        OrderExample.Criteria criteria1 = example.createCriteria();
        criteria1.andUserSupplierIdEqualTo(userId);
        example.or(criteria1);
        return orderMapper.selectByExample(example);
    }

    /**
     * 获取输入订单中的所有Product
     * @param orders
     * @return
     */
    public List<Product> getProductsByOrders(List<Order> orders) {
        List<Product> products = new ArrayList<>();
        for (Order order : orders) {
            Product product = productMapper.selectByPrimaryKey(order.getProSupplierId());
            products.add(product);
        }
        return products;
    }

    /**
     * 更新订单状态
     * @param id
     * @param status
     * @return
     */
    public Msg updateOrderStatus(int id, int status) {
        Order order = getOrder(id);
        order.setStatus(status);
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return Msg.response(orderMapper.updateByExampleSelective(order, example) >= 1 ?
                Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }
}
