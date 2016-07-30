package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XtSsglExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtSsglExample() {
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

        public Criteria andSsmcIsNull() {
            addCriterion("ssmc is null");
            return (Criteria) this;
        }

        public Criteria andSsmcIsNotNull() {
            addCriterion("ssmc is not null");
            return (Criteria) this;
        }

        public Criteria andSsmcEqualTo(String value) {
            addCriterion("ssmc =", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcNotEqualTo(String value) {
            addCriterion("ssmc <>", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcGreaterThan(String value) {
            addCriterion("ssmc >", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcGreaterThanOrEqualTo(String value) {
            addCriterion("ssmc >=", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcLessThan(String value) {
            addCriterion("ssmc <", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcLessThanOrEqualTo(String value) {
            addCriterion("ssmc <=", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcLike(String value) {
            addCriterion("ssmc like", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcNotLike(String value) {
            addCriterion("ssmc not like", value, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcIn(List<String> values) {
            addCriterion("ssmc in", values, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcNotIn(List<String> values) {
            addCriterion("ssmc not in", values, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcBetween(String value1, String value2) {
            addCriterion("ssmc between", value1, value2, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsmcNotBetween(String value1, String value2) {
            addCriterion("ssmc not between", value1, value2, "ssmc");
            return (Criteria) this;
        }

        public Criteria andSsddIsNull() {
            addCriterion("ssdd is null");
            return (Criteria) this;
        }

        public Criteria andSsddIsNotNull() {
            addCriterion("ssdd is not null");
            return (Criteria) this;
        }

        public Criteria andSsddEqualTo(String value) {
            addCriterion("ssdd =", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddNotEqualTo(String value) {
            addCriterion("ssdd <>", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddGreaterThan(String value) {
            addCriterion("ssdd >", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddGreaterThanOrEqualTo(String value) {
            addCriterion("ssdd >=", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddLessThan(String value) {
            addCriterion("ssdd <", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddLessThanOrEqualTo(String value) {
            addCriterion("ssdd <=", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddLike(String value) {
            addCriterion("ssdd like", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddNotLike(String value) {
            addCriterion("ssdd not like", value, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddIn(List<String> values) {
            addCriterion("ssdd in", values, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddNotIn(List<String> values) {
            addCriterion("ssdd not in", values, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddBetween(String value1, String value2) {
            addCriterion("ssdd between", value1, value2, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSsddNotBetween(String value1, String value2) {
            addCriterion("ssdd not between", value1, value2, "ssdd");
            return (Criteria) this;
        }

        public Criteria andSskssjIsNull() {
            addCriterion("sskssj is null");
            return (Criteria) this;
        }

        public Criteria andSskssjIsNotNull() {
            addCriterion("sskssj is not null");
            return (Criteria) this;
        }

        public Criteria andSskssjEqualTo(Date value) {
            addCriterion("sskssj =", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjNotEqualTo(Date value) {
            addCriterion("sskssj <>", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjGreaterThan(Date value) {
            addCriterion("sskssj >", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjGreaterThanOrEqualTo(Date value) {
            addCriterion("sskssj >=", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjLessThan(Date value) {
            addCriterion("sskssj <", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjLessThanOrEqualTo(Date value) {
            addCriterion("sskssj <=", value, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjIn(List<Date> values) {
            addCriterion("sskssj in", values, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjNotIn(List<Date> values) {
            addCriterion("sskssj not in", values, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjBetween(Date value1, Date value2) {
            addCriterion("sskssj between", value1, value2, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSskssjNotBetween(Date value1, Date value2) {
            addCriterion("sskssj not between", value1, value2, "sskssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjIsNull() {
            addCriterion("ssjssj is null");
            return (Criteria) this;
        }

        public Criteria andSsjssjIsNotNull() {
            addCriterion("ssjssj is not null");
            return (Criteria) this;
        }

        public Criteria andSsjssjEqualTo(Date value) {
            addCriterion("ssjssj =", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjNotEqualTo(Date value) {
            addCriterion("ssjssj <>", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjGreaterThan(Date value) {
            addCriterion("ssjssj >", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjGreaterThanOrEqualTo(Date value) {
            addCriterion("ssjssj >=", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjLessThan(Date value) {
            addCriterion("ssjssj <", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjLessThanOrEqualTo(Date value) {
            addCriterion("ssjssj <=", value, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjIn(List<Date> values) {
            addCriterion("ssjssj in", values, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjNotIn(List<Date> values) {
            addCriterion("ssjssj not in", values, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjBetween(Date value1, Date value2) {
            addCriterion("ssjssj between", value1, value2, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andSsjssjNotBetween(Date value1, Date value2) {
            addCriterion("ssjssj not between", value1, value2, "ssjssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjIsNull() {
            addCriterion("cjkssj is null");
            return (Criteria) this;
        }

        public Criteria andCjkssjIsNotNull() {
            addCriterion("cjkssj is not null");
            return (Criteria) this;
        }

        public Criteria andCjkssjEqualTo(Date value) {
            addCriterion("cjkssj =", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjNotEqualTo(Date value) {
            addCriterion("cjkssj <>", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjGreaterThan(Date value) {
            addCriterion("cjkssj >", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjGreaterThanOrEqualTo(Date value) {
            addCriterion("cjkssj >=", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjLessThan(Date value) {
            addCriterion("cjkssj <", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjLessThanOrEqualTo(Date value) {
            addCriterion("cjkssj <=", value, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjIn(List<Date> values) {
            addCriterion("cjkssj in", values, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjNotIn(List<Date> values) {
            addCriterion("cjkssj not in", values, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjBetween(Date value1, Date value2) {
            addCriterion("cjkssj between", value1, value2, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjkssjNotBetween(Date value1, Date value2) {
            addCriterion("cjkssj not between", value1, value2, "cjkssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjIsNull() {
            addCriterion("cjjssj is null");
            return (Criteria) this;
        }

        public Criteria andCjjssjIsNotNull() {
            addCriterion("cjjssj is not null");
            return (Criteria) this;
        }

        public Criteria andCjjssjEqualTo(Date value) {
            addCriterion("cjjssj =", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjNotEqualTo(Date value) {
            addCriterion("cjjssj <>", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjGreaterThan(Date value) {
            addCriterion("cjjssj >", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjGreaterThanOrEqualTo(Date value) {
            addCriterion("cjjssj >=", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjLessThan(Date value) {
            addCriterion("cjjssj <", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjLessThanOrEqualTo(Date value) {
            addCriterion("cjjssj <=", value, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjIn(List<Date> values) {
            addCriterion("cjjssj in", values, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjNotIn(List<Date> values) {
            addCriterion("cjjssj not in", values, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjBetween(Date value1, Date value2) {
            addCriterion("cjjssj between", value1, value2, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andCjjssjNotBetween(Date value1, Date value2) {
            addCriterion("cjjssj not between", value1, value2, "cjjssj");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(Integer value) {
            addCriterion("zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(Integer value) {
            addCriterion("zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(Integer value) {
            addCriterion("zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(Integer value) {
            addCriterion("zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(Integer value) {
            addCriterion("zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<Integer> values) {
            addCriterion("zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<Integer> values) {
            addCriterion("zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(Integer value1, Integer value2) {
            addCriterion("zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(Integer value1, Integer value2) {
            addCriterion("zt not between", value1, value2, "zt");
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