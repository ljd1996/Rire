package com.hearing.rire.util;

/**
 * Create by hearing on 19-4-13
 */
public class Constant {

    /**
     * Product的类型
     */
    public static final String TYPE_GOODS = "goods";                // 所有商品
    public static final String TYPE_DEMAND = "demand";              // 所有需求
    public static final String TYPE_MY_GOODS = "mygoods";           // 我的商品
    public static final String TYPE_MY_Demand = "mydemand";         // 我的需求
    public static final String TYPE_A = "TypeA";                    // 类型A
    public static final String TYPE_B = "TypeB";                    // 类型B
    public static final String TYPE_C = "TypeC";                    // 类型C
    public static final String TYPE_D = "TypeD";                    // 类型D
    public static final String TYPE_E = "TypeE";                    // 类型E
    public static final String TYPE_F = "TypeF";                    // 类型F
    public static final String TYPE_G = "TypeG";                    // 类型G

    /**
     * 首页商品的需求的展示数目
     */
    public static final int INDEX_SHOW_NUM = 3;

    public static final int PRO_TYPE_GOODS = 0;                     // 表示商品
    public static final int PRO_TYPE_DEMAND = 1;                    // 表示需求

    /**
     * Product的状态
     */
    public static final int PRO_STATUS_ON = 0;                      // 在架
    public static final int PRO_STATUS_OFF = 1;                     // 下架
    public static final int PRO_STATUS_SELLED = 2;                  // 已交易
    public static final int PRO_STATUS_LOCKED = 3;                  // 锁定中

    public static final int ORDER_STATUS_CONTRACT_NOT_CONFIRM = 0;  // 合同待确认
    public static final int ORDER_STATUS_CONTRACT_CONFIRM = 1;      // 合同确认
    public static final int ORDER_STATUS_CONTRACT_NOT_DELIVERY = 2; // 已支付待发货
    public static final int ORDER_STATUS_CONTRACT_DELIVERY = 3;     // 已发货
    public static final int ORDER_STATUS_CONTRACT_GOODS = 4;        // 已收货
    public static final int ORDER_STATUS_CONTRACT_REFUND = 5;       // 退款中
    public static final int ORDER_STATUS_CONTRACT_REGOODS = 6;      // 退款退货中
    public static final int ORDER_STATUS_CONTRACT_CANCEL = 7;       // 已取消
}
