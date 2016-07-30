package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class XtSsgwExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtSsgwExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSsidIsNull() {
            addCriterion("ssid is null");
            return (Criteria) this;
        }

        public Criteria andSsidIsNotNull() {
            addCriterion("ssid is not null");
            return (Criteria) this;
        }

        public Criteria andSsidEqualTo(String value) {
            addCriterion("ssid =", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotEqualTo(String value) {
            addCriterion("ssid <>", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThan(String value) {
            addCriterion("ssid >", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThanOrEqualTo(String value) {
            addCriterion("ssid >=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThan(String value) {
            addCriterion("ssid <", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThanOrEqualTo(String value) {
            addCriterion("ssid <=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLike(String value) {
            addCriterion("ssid like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotLike(String value) {
            addCriterion("ssid not like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidIn(List<String> values) {
            addCriterion("ssid in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotIn(List<String> values) {
            addCriterion("ssid not in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidBetween(String value1, String value2) {
            addCriterion("ssid between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotBetween(String value1, String value2) {
            addCriterion("ssid not between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andGwmcIsNull() {
            addCriterion("gwmc is null");
            return (Criteria) this;
        }

        public Criteria andGwmcIsNotNull() {
            addCriterion("gwmc is not null");
            return (Criteria) this;
        }

        public Criteria andGwmcEqualTo(String value) {
            addCriterion("gwmc =", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotEqualTo(String value) {
            addCriterion("gwmc <>", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcGreaterThan(String value) {
            addCriterion("gwmc >", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcGreaterThanOrEqualTo(String value) {
            addCriterion("gwmc >=", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLessThan(String value) {
            addCriterion("gwmc <", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLessThanOrEqualTo(String value) {
            addCriterion("gwmc <=", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLike(String value) {
            addCriterion("gwmc like", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotLike(String value) {
            addCriterion("gwmc not like", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcIn(List<String> values) {
            addCriterion("gwmc in", values, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotIn(List<String> values) {
            addCriterion("gwmc not in", values, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcBetween(String value1, String value2) {
            addCriterion("gwmc between", value1, value2, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotBetween(String value1, String value2) {
            addCriterion("gwmc not between", value1, value2, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwslIsNull() {
            addCriterion("Gwsl is null");
            return (Criteria) this;
        }

        public Criteria andGwslIsNotNull() {
            addCriterion("Gwsl is not null");
            return (Criteria) this;
        }

        public Criteria andGwslEqualTo(Integer value) {
            addCriterion("Gwsl =", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslNotEqualTo(Integer value) {
            addCriterion("Gwsl <>", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslGreaterThan(Integer value) {
            addCriterion("Gwsl >", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslGreaterThanOrEqualTo(Integer value) {
            addCriterion("Gwsl >=", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslLessThan(Integer value) {
            addCriterion("Gwsl <", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslLessThanOrEqualTo(Integer value) {
            addCriterion("Gwsl <=", value, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslIn(List<Integer> values) {
            addCriterion("Gwsl in", values, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslNotIn(List<Integer> values) {
            addCriterion("Gwsl not in", values, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslBetween(Integer value1, Integer value2) {
            addCriterion("Gwsl between", value1, value2, "gwsl");
            return (Criteria) this;
        }

        public Criteria andGwslNotBetween(Integer value1, Integer value2) {
            addCriterion("Gwsl not between", value1, value2, "gwsl");
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