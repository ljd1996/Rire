package com.hearing.rire.dao;

import com.hearing.rire.bean.BidList;
import com.hearing.rire.bean.BidListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BidListMapper {
    long countByExample(BidListExample example);

    int deleteByExample(BidListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BidList record);

    int insertSelective(BidList record);

    List<BidList> selectByExample(BidListExample example);

    BidList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BidList record, @Param("example") BidListExample example);

    int updateByExample(@Param("record") BidList record, @Param("example") BidListExample example);

    int updateByPrimaryKeySelective(BidList record);

    int updateByPrimaryKey(BidList record);
}