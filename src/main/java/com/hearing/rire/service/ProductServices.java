package com.hearing.rire.service;

import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.ProductExample;
import com.hearing.rire.bean.User;
import com.hearing.rire.dao.ProductMapper;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Create by hearing on 19-4-13
 */

@Service
public class ProductServices {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserServices userServices;

    @Autowired
    private BidListServices bidListServices;


    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public Msg addProduct(Product product) {
        return Msg.response(productMapper.insertAndGetId(product) > 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL).add("productId", product.getId());
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

    public List<Product> getMyDemand(int userId, boolean online) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1).andUserIdEqualTo(userId);
        if (online) {
            criteria.andStatusEqualTo(0);
        }
        return productMapper.selectByExample(example);
    }

    public List<Product> getMyGoods(int userId, boolean online) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0).andUserIdEqualTo(userId);
        if (online) {
            criteria.andStatusEqualTo(0);
        }
        return productMapper.selectByExample(example);
    }

    public Msg updateProductStatus(int id, int status) {
        Product product = getProduct(id);
        product.setStatus(status);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return Msg.response(productMapper.updateByExampleSelective(product, example) >= 1 ?
                Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public Msg updateProduct(Product product) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(product.getId());
        return Msg.response(productMapper.updateByExampleSelective(product, example) >= 1 ?
                Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public Msg deleteProduct(int id) {
        return Msg.response(productMapper.deleteByPrimaryKey(id) >= 1 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    public void getProductDetail(Map<String, Object> map, Integer productId) {
        Product product = getProduct(productId);
        map.put("product", product);
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(product.getTime()));
        User user = userServices.getCurrentUser();
        boolean owner = false;
        if (user != null) {
            if (user.getId().equals(product.getUserId())) {
                owner = true;
            } else {
                map.put("myGoods", getMyGoods(user.getId(), true));
            }
        }
        map.put("owner", owner);
        map.put("user", userServices.getUserById(product.getUserId()).getName());
        map.put("bidProducts", bidListServices.getBidProductByMainId(productId));
    }
}
