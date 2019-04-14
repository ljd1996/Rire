package com.hearing.rire.bean;

import java.util.ArrayList;
import java.util.List;

public class BidListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BidListExample() {
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

        public Criteria andMainidIsNull() {
            addCriterion("mainid is null");
            return (Criteria) this;
        }

        public Criteria andMainidIsNotNull() {
            addCriterion("mainid is not null");
            return (Criteria) this;
        }

        public Criteria andMainidEqualTo(Integer value) {
            addCriterion("mainid =", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotEqualTo(Integer value) {
            addCriterion("mainid <>", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThan(Integer value) {
            addCriterion("mainid >", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mainid >=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThan(Integer value) {
            addCriterion("mainid <", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThanOrEqualTo(Integer value) {
            addCriterion("mainid <=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidIn(List<Integer> values) {
            addCriterion("mainid in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotIn(List<Integer> values) {
            addCriterion("mainid not in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidBetween(Integer value1, Integer value2) {
            addCriterion("mainid between", value1, value2, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotBetween(Integer value1, Integer value2) {
            addCriterion("mainid not between", value1, value2, "mainid");
            return (Criteria) this;
        }

        public Criteria andFollowidIsNull() {
            addCriterion("followid is null");
            return (Criteria) this;
        }

        public Criteria andFollowidIsNotNull() {
            addCriterion("followid is not null");
            return (Criteria) this;
        }

        public Criteria andFollowidEqualTo(Integer value) {
            addCriterion("followid =", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotEqualTo(Integer value) {
            addCriterion("followid <>", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThan(Integer value) {
            addCriterion("followid >", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidGreaterThanOrEqualTo(Integer value) {
            addCriterion("followid >=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThan(Integer value) {
            addCriterion("followid <", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidLessThanOrEqualTo(Integer value) {
            addCriterion("followid <=", value, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidIn(List<Integer> values) {
            addCriterion("followid in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotIn(List<Integer> values) {
            addCriterion("followid not in", values, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidBetween(Integer value1, Integer value2) {
            addCriterion("followid between", value1, value2, "followid");
            return (Criteria) this;
        }

        public Criteria andFollowidNotBetween(Integer value1, Integer value2) {
            addCriterion("followid not between", value1, value2, "followid");
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