package com.hearing.rire.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdIsNull() {
            addCriterion("user_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdIsNotNull() {
            addCriterion("user_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdEqualTo(Integer value) {
            addCriterion("user_supplier_id =", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdNotEqualTo(Integer value) {
            addCriterion("user_supplier_id <>", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdGreaterThan(Integer value) {
            addCriterion("user_supplier_id >", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_supplier_id >=", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdLessThan(Integer value) {
            addCriterion("user_supplier_id <", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_supplier_id <=", value, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdIn(List<Integer> values) {
            addCriterion("user_supplier_id in", values, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdNotIn(List<Integer> values) {
            addCriterion("user_supplier_id not in", values, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("user_supplier_id between", value1, value2, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_supplier_id not between", value1, value2, "userSupplierId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdIsNull() {
            addCriterion("user_buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdIsNotNull() {
            addCriterion("user_buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdEqualTo(Integer value) {
            addCriterion("user_buyer_id =", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdNotEqualTo(Integer value) {
            addCriterion("user_buyer_id <>", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdGreaterThan(Integer value) {
            addCriterion("user_buyer_id >", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_buyer_id >=", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdLessThan(Integer value) {
            addCriterion("user_buyer_id <", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_buyer_id <=", value, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdIn(List<Integer> values) {
            addCriterion("user_buyer_id in", values, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdNotIn(List<Integer> values) {
            addCriterion("user_buyer_id not in", values, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdBetween(Integer value1, Integer value2) {
            addCriterion("user_buyer_id between", value1, value2, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andUserBuyerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_buyer_id not between", value1, value2, "userBuyerId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdIsNull() {
            addCriterion("pro_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdIsNotNull() {
            addCriterion("pro_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdEqualTo(Integer value) {
            addCriterion("pro_supplier_id =", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdNotEqualTo(Integer value) {
            addCriterion("pro_supplier_id <>", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdGreaterThan(Integer value) {
            addCriterion("pro_supplier_id >", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_supplier_id >=", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdLessThan(Integer value) {
            addCriterion("pro_supplier_id <", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_supplier_id <=", value, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdIn(List<Integer> values) {
            addCriterion("pro_supplier_id in", values, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdNotIn(List<Integer> values) {
            addCriterion("pro_supplier_id not in", values, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_supplier_id between", value1, value2, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_supplier_id not between", value1, value2, "proSupplierId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdIsNull() {
            addCriterion("pro_buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdIsNotNull() {
            addCriterion("pro_buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdEqualTo(Integer value) {
            addCriterion("pro_buyer_id =", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdNotEqualTo(Integer value) {
            addCriterion("pro_buyer_id <>", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdGreaterThan(Integer value) {
            addCriterion("pro_buyer_id >", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_buyer_id >=", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdLessThan(Integer value) {
            addCriterion("pro_buyer_id <", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_buyer_id <=", value, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdIn(List<Integer> values) {
            addCriterion("pro_buyer_id in", values, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdNotIn(List<Integer> values) {
            addCriterion("pro_buyer_id not in", values, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_buyer_id between", value1, value2, "proBuyerId");
            return (Criteria) this;
        }

        public Criteria andProBuyerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_buyer_id not between", value1, value2, "proBuyerId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}