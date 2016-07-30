package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class XtSsjjysbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtSsjjysbExample() {
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

        public Criteria andSsjjyidIsNull() {
            addCriterion("ssjjyid is null");
            return (Criteria) this;
        }

        public Criteria andSsjjyidIsNotNull() {
            addCriterion("ssjjyid is not null");
            return (Criteria) this;
        }

        public Criteria andSsjjyidEqualTo(Long value) {
            addCriterion("ssjjyid =", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidNotEqualTo(Long value) {
            addCriterion("ssjjyid <>", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidGreaterThan(Long value) {
            addCriterion("ssjjyid >", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidGreaterThanOrEqualTo(Long value) {
            addCriterion("ssjjyid >=", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidLessThan(Long value) {
            addCriterion("ssjjyid <", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidLessThanOrEqualTo(Long value) {
            addCriterion("ssjjyid <=", value, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidIn(List<Long> values) {
            addCriterion("ssjjyid in", values, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidNotIn(List<Long> values) {
            addCriterion("ssjjyid not in", values, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidBetween(Long value1, Long value2) {
            addCriterion("ssjjyid between", value1, value2, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSsjjyidNotBetween(Long value1, Long value2) {
            addCriterion("ssjjyid not between", value1, value2, "ssjjyid");
            return (Criteria) this;
        }

        public Criteria andSbidIsNull() {
            addCriterion("sbid is null");
            return (Criteria) this;
        }

        public Criteria andSbidIsNotNull() {
            addCriterion("sbid is not null");
            return (Criteria) this;
        }

        public Criteria andSbidEqualTo(Long value) {
            addCriterion("sbid =", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotEqualTo(Long value) {
            addCriterion("sbid <>", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThan(Long value) {
            addCriterion("sbid >", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidGreaterThanOrEqualTo(Long value) {
            addCriterion("sbid >=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThan(Long value) {
            addCriterion("sbid <", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidLessThanOrEqualTo(Long value) {
            addCriterion("sbid <=", value, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidIn(List<Long> values) {
            addCriterion("sbid in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotIn(List<Long> values) {
            addCriterion("sbid not in", values, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidBetween(Long value1, Long value2) {
            addCriterion("sbid between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andSbidNotBetween(Long value1, Long value2) {
            addCriterion("sbid not between", value1, value2, "sbid");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("Zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("Zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(Integer value) {
            addCriterion("Zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(Integer value) {
            addCriterion("Zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(Integer value) {
            addCriterion("Zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("Zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(Integer value) {
            addCriterion("Zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(Integer value) {
            addCriterion("Zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<Integer> values) {
            addCriterion("Zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<Integer> values) {
            addCriterion("Zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(Integer value1, Integer value2) {
            addCriterion("Zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(Integer value1, Integer value2) {
            addCriterion("Zt not between", value1, value2, "zt");
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