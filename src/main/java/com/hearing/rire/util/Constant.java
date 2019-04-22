package com.hearing.rire.util;

/**
 * Create by hearing on 19-4-13
 */
public class Constant {
    public static final String TYPE_GOODS = "goods";
    public static final String TYPE_DEMAND = "demand";
    public static final String TYPE_MY_GOODS = "mygoods";
    public static final String TYPE_MY_Demand = "mydemand";
    public static final String TYPE_A = "TypeA";
    public static final String TYPE_B = "TypeB";
    public static final String TYPE_C = "TypeC";
    public static final String TYPE_D = "TypeD";
    public static final String TYPE_E = "TypeE";
    public static final String TYPE_F = "TypeF";
    public static final String TYPE_G = "TypeG";

    public static final int PRO_TYPE_GOODS = 0;
    public static final int PRO_TYPE_DEMAND = 1;

    public static final int PRO_STATUS_ON = 0;
    public static final int PRO_STATUS_OFF = 1;
    public static final int PRO_STATUS_SELLED = 2;
    public static final int PRO_STATUS_LOCKED = 3;

    public static final int ORDER_STATUS_CONTRACT_NOT_CONFIRM = 0;  // 合同待确认
    public static final int ORDER_STATUS_CONTRACT_CONFIRM = 1;      // 合同确认
    public static final int ORDER_STATUS_CONTRACT_NOT_DELIVERY = 2; // 已支付待发货
    public static final int ORDER_STATUS_CONTRACT_DELIVERY = 3;     // 已发货
    public static final int ORDER_STATUS_CONTRACT_GOODS = 4;        // 已收货
    public static final int ORDER_STATUS_CONTRACT_REFUND = 5;       // 退款中
    public static final int ORDER_STATUS_CONTRACT_REGOODS = 6;      // 退款退货中
    public static final int ORDER_STATUS_CONTRACT_CANCEL = 7;       // 已取消
}
