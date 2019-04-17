package com.hearing.rire.controller;

import com.hearing.rire.bean.BidList;
import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.User;
import com.hearing.rire.service.BidListServices;
import com.hearing.rire.service.OrderServices;
import com.hearing.rire.service.ProductServices;
import com.hearing.rire.service.UserServices;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * Create by hearing on 19-4-12
 */
@RestController
public class JsonController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private BidListServices bidListServices;

    @Autowired
    private OrderServices orderServices;


    @GetMapping("/current_user")
    public User getUser() {
        return userServices.getCurrentUser();
    }

    @GetMapping("/my_goods")
    public List<Product> getMyGoods(Integer id) {
        return productServices.getMyGoods(id, true);
    }

    @PostMapping("/bid")
    public Msg bid(BidList bidList) {
        return bidListServices.addBid(bidList);
    }

    @GetMapping("/set_status")
    public Msg setStatus(@RequestParam("id") int id, @RequestParam("status") int status) {
        return productServices.updateProductStatus(id, status);
    }

    @GetMapping("/set_order_status")
    public Msg setOrderStatus(@RequestParam("id") int id, @RequestParam("status") int status) {
        return orderServices.updateOrderStatus(id, status);
    }
}
