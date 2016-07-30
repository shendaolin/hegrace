package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class XtDmlbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtDmlbExample() {
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

        public Criteria andLbidIsNull() {
            addCriterion("lbid is null");
            return (Criteria) this;
        }

        public Criteria andLbidIsNotNull() {
            addCriterion("lbid is not null");
            return (Criteria) this;
        }

        public Criteria andLbidEqualTo(Integer value) {
            addCriterion("lbid =", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidNotEqualTo(Integer value) {
            addCriterion("lbid <>", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidGreaterThan(Integer value) {
            addCriterion("lbid >", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lbid >=", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidLessThan(Integer value) {
            addCriterion("lbid <", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidLessThanOrEqualTo(Integer value) {
            addCriterion("lbid <=", value, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidIn(List<Integer> values) {
            addCriterion("lbid in", values, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidNotIn(List<Integer> values) {
            addCriterion("lbid not in", values, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidBetween(Integer value1, Integer value2) {
            addCriterion("lbid between", value1, value2, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbidNotBetween(Integer value1, Integer value2) {
            addCriterion("lbid not between", value1, value2, "lbid");
            return (Criteria) this;
        }

        public Criteria andLbmcIsNull() {
            addCriterion("lbmc is null");
            return (Criteria) this;
        }

        public Criteria andLbmcIsNotNull() {
            addCriterion("lbmc is not null");
            return (Criteria) this;
        }

        public Criteria andLbmcEqualTo(String value) {
            addCriterion("lbmc =", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotEqualTo(String value) {
            addCriterion("lbmc <>", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcGreaterThan(String value) {
            addCriterion("lbmc >", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcGreaterThanOrEqualTo(String value) {
            addCriterion("lbmc >=", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLessThan(String value) {
            addCriterion("lbmc <", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLessThanOrEqualTo(String value) {
            addCriterion("lbmc <=", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLike(String value) {
            addCriterion("lbmc like", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotLike(String value) {
            addCriterion("lbmc not like", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcIn(List<String> values) {
            addCriterion("lbmc in", values, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotIn(List<String> values) {
            addCriterion("lbmc not in", values, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcBetween(String value1, String value2) {
            addCriterion("lbmc between", value1, value2, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotBetween(String value1, String value2) {
            addCriterion("lbmc not between", value1, value2, "lbmc");
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