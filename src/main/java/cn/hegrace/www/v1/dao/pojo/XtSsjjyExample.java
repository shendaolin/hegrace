package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class XtSsjjyExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtSsjjyExample() {
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

        public Criteria andRyidIsNull() {
            addCriterion("ryid is null");
            return (Criteria) this;
        }

        public Criteria andRyidIsNotNull() {
            addCriterion("ryid is not null");
            return (Criteria) this;
        }

        public Criteria andRyidEqualTo(String value) {
            addCriterion("ryid =", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotEqualTo(String value) {
            addCriterion("ryid <>", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidGreaterThan(String value) {
            addCriterion("ryid >", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidGreaterThanOrEqualTo(String value) {
            addCriterion("ryid >=", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLessThan(String value) {
            addCriterion("ryid <", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLessThanOrEqualTo(String value) {
            addCriterion("ryid <=", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLike(String value) {
            addCriterion("ryid like", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotLike(String value) {
            addCriterion("ryid not like", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidIn(List<String> values) {
            addCriterion("ryid in", values, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotIn(List<String> values) {
            addCriterion("ryid not in", values, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidBetween(String value1, String value2) {
            addCriterion("ryid between", value1, value2, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotBetween(String value1, String value2) {
            addCriterion("ryid not between", value1, value2, "ryid");
            return (Criteria) this;
        }

        public Criteria andGwidIsNull() {
            addCriterion("gwid is null");
            return (Criteria) this;
        }

        public Criteria andGwidIsNotNull() {
            addCriterion("gwid is not null");
            return (Criteria) this;
        }

        public Criteria andGwidEqualTo(String value) {
            addCriterion("gwid =", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotEqualTo(String value) {
            addCriterion("gwid <>", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidGreaterThan(String value) {
            addCriterion("gwid >", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidGreaterThanOrEqualTo(String value) {
            addCriterion("gwid >=", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidLessThan(String value) {
            addCriterion("gwid <", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidLessThanOrEqualTo(String value) {
            addCriterion("gwid <=", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidLike(String value) {
            addCriterion("gwid like", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotLike(String value) {
            addCriterion("gwid not like", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidIn(List<String> values) {
            addCriterion("gwid in", values, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotIn(List<String> values) {
            addCriterion("gwid not in", values, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidBetween(String value1, String value2) {
            addCriterion("gwid between", value1, value2, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotBetween(String value1, String value2) {
            addCriterion("gwid not between", value1, value2, "gwid");
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

        public Criteria andZbIsNull() {
            addCriterion("zb is null");
            return (Criteria) this;
        }

        public Criteria andZbIsNotNull() {
            addCriterion("zb is not null");
            return (Criteria) this;
        }

        public Criteria andZbEqualTo(String value) {
            addCriterion("zb =", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotEqualTo(String value) {
            addCriterion("zb <>", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbGreaterThan(String value) {
            addCriterion("zb >", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbGreaterThanOrEqualTo(String value) {
            addCriterion("zb >=", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbLessThan(String value) {
            addCriterion("zb <", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbLessThanOrEqualTo(String value) {
            addCriterion("zb <=", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbLike(String value) {
            addCriterion("zb like", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotLike(String value) {
            addCriterion("zb not like", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbIn(List<String> values) {
            addCriterion("zb in", values, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotIn(List<String> values) {
            addCriterion("zb not in", values, "zb");
            return (Criteria) this;
        }

        public Criteria andZbBetween(String value1, String value2) {
            addCriterion("zb between", value1, value2, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotBetween(String value1, String value2) {
            addCriterion("zb not between", value1, value2, "zb");
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