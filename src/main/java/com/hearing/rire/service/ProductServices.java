package com.hearing.rire.service;

import com.hearing.rire.bean.Product;
import com.hearing.rire.dao.ProductMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by hearing on 19-4-13
 */

@Service
public class ProductServices {

    @Autowired
    private ProductMapper productMapper;

    public Msg addProduct(Product product) {
        return Msg.response(productMapper.insert(product) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }
}
