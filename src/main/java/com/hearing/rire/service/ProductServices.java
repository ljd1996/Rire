package com.hearing.rire.service;

import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.ProductExample;
import com.hearing.rire.bean.User;
import com.hearing.rire.bean.UserExample;
import com.hearing.rire.dao.ProductMapper;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


    /**
     * 根据primary id获取Product
     *
     * @param id
     * @return
     */
    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加Product
     *
     * @param product
     * @return
     */
    public Msg addProduct(Product product) {
        return Msg.response(productMapper.insertAndGetId(product) > 0 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL).add("productId", product.getId());
    }

    /**
     * 获取所有商品
     *
     * @return
     */
    public List<Product> getAllGoods() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    /**
     * 获取指定类型的商品
     *
     * @param proType
     * @return
     */
    public List<Product> getGoodsByType(String proType) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProTypeEqualTo(proType);
        criteria.andTypeEqualTo(0).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    /**
     * 获取所有需求
     *
     * @return
     */
    public List<Product> getAllDemand() {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    /**
     * 获取指定类型的需求
     *
     * @param proType
     * @return
     */
    public List<Product> getDemandByType(String proType) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andProTypeEqualTo(proType);
        criteria.andTypeEqualTo(1).andStatusEqualTo(Constant.PRO_STATUS_ON);
        return productMapper.selectByExample(example);
    }

    /**
     * 获取当前登录用户的需求
     *
     * @param userId
     * @param online
     * @return
     */
    public List<Product> getMyDemand(int userId, boolean online) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(1).andUserIdEqualTo(userId);
        if (online) {
            criteria.andStatusEqualTo(0);
        }
        return productMapper.selectByExample(example);
    }

    /**
     * 获取当前登录用户的商品
     *
     * @param userId
     * @param online
     * @return
     */
    public List<Product> getMyGoods(int userId, boolean online) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(0).andUserIdEqualTo(userId);
        if (online) {
            criteria.andStatusEqualTo(0);
        }
        return productMapper.selectByExample(example);
    }

    public List<Product> search(int type, int searchType, String name) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();

        if (searchType == Constant.SEARCH_TYPE_PRODUCT_NAME) {
            criteria.andTypeEqualTo(type).andNameLike("%" + name + "%");
            return productMapper.selectByExample(example);
        } else if (searchType == Constant.SEARCH_TYPE_USER_NAME) {
            List<User> users = userServices.searchUser(name);
            List<Product> products = new ArrayList<>();
            for (User user : users) {
                criteria.andTypeEqualTo(type).andUserIdEqualTo(user.getId());
                products.addAll(productMapper.selectByExample(example));
            }
            return products;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 更新Product status
     *
     * @param id
     * @param status
     * @return
     */
    public Msg updateProductStatus(int id, int status) {
        Product product = getProduct(id);
        product.setStatus(status);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return Msg.response(productMapper.updateByExampleSelective(product, example) >= 1 ?
                Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 修改Product信息
     *
     * @param product
     * @return
     */
    public Msg updateProduct(Product product) {
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(product.getId());
        return Msg.response(productMapper.updateByExampleSelective(product, example) >= 1 ?
                Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 删除Product
     *
     * @param id
     * @return
     */
    public Msg deleteProduct(int id) {
        return Msg.response(productMapper.deleteByPrimaryKey(id) >= 1 ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 获取Product详情
     *
     * @param map
     * @param productId
     */
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
