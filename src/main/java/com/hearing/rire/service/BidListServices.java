package com.hearing.rire.service;

import com.hearing.rire.bean.BidList;
import com.hearing.rire.bean.BidListExample;
import com.hearing.rire.bean.Product;
import com.hearing.rire.dao.BidListMapper;
import com.hearing.rire.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by hearing on 19-4-14
 */
@Service
public class BidListServices {

    @Autowired
    private BidListMapper bidListMapper;

    @Autowired
    private ProductServices productServices;


    /**
     * 添加bidlist
     * @param bidList
     * @return
     */
    public Msg addBid(BidList bidList) {
        int mainId = bidList.getMainid();
        int followId = bidList.getFollowid();
        BidList bidList1 = new BidList();
        bidList1.setFollowid(mainId);
        bidList1.setMainid(followId);
        return Msg.response(bidListMapper.insert(bidList) >= 0 && bidListMapper.insert(bidList1) >= 0
                ? Msg.CODE_SUCCESS : Msg.CODE_FAIL);
    }

    /**
     * 通过mainId获取bidlist
     * @param mainId
     * @return
     */
    public List<BidList> getBidListByMainId(int mainId) {
        BidListExample example = new BidListExample();
        BidListExample.Criteria criteria = example.createCriteria();
        criteria.andMainidEqualTo(mainId);
        return bidListMapper.selectByExample(example);
    }

    /**
     * 通过mainId获取产品list
     * @param mainId
     * @return
     */
    public List<Product> getBidProductByMainId(int mainId) {
        BidListExample example = new BidListExample();
        BidListExample.Criteria criteria = example.createCriteria();
        criteria.andMainidEqualTo(mainId);
        List<BidList> bidLists = bidListMapper.selectByExample(example);
        List<Product> products = new ArrayList<>();
        for (BidList bidList : bidLists) {
            products.add(productServices.getProduct(bidList.getFollowid()));
        }
        return products;
    }
}
