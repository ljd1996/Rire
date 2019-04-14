package com.hearing.rire.service;

import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.ProductExample;
import com.hearing.rire.dao.ProductMapper;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by hearing on 19-4-13
 */

@Service
public class ProductServices {

    @Autowired
    private ProductMapper productMapper;

    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public Msg addProduct(Product product) {
        return Msg.response(productMapper.insert(product) >= 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public List<Product> getAllGoods() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    public List<Product> getGoodsByType(String proType) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProTypeEqualTo(proType);
        criteria.andTypeEqualTo(0).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    public List<Product> getAllDemand() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    public List<Product> getDemandByType(String proType) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProTypeEqualTo(proType);
        criteria.andTypeEqualTo(1).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    public List<Product> getMyDemand(int userId) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1).andUserIdEqualTo(userId);
        return productMapper.selectByExample(example);
    }

    public List<Product> getMyGoods(int userId) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0).andUserIdEqualTo(userId);
        return productMapper.selectByExample(example);
    }
}
