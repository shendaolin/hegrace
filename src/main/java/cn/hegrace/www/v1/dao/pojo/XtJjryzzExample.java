package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class XtJjryzzExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtJjryzzExample() {
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

        public Criteria andRyidIsNull() {
            addCriterion("ryId is null");
            return (Criteria) this;
        }

        public Criteria andRyidIsNotNull() {
            addCriterion("ryId is not null");
            return (Criteria) this;
        }

        public Criteria andRyidEqualTo(String value) {
            addCriterion("ryId =", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotEqualTo(String value) {
            addCriterion("ryId <>", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidGreaterThan(String value) {
            addCriterion("ryId >", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidGreaterThanOrEqualTo(String value) {
            addCriterion("ryId >=", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLessThan(String value) {
            addCriterion("ryId <", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLessThanOrEqualTo(String value) {
            addCriterion("ryId <=", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidLike(String value) {
            addCriterion("ryId like", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotLike(String value) {
            addCriterion("ryId not like", value, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidIn(List<String> values) {
            addCriterion("ryId in", values, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotIn(List<String> values) {
            addCriterion("ryId not in", values, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidBetween(String value1, String value2) {
            addCriterion("ryId between", value1, value2, "ryid");
            return (Criteria) this;
        }

        public Criteria andRyidNotBetween(String value1, String value2) {
            addCriterion("ryId not between", value1, value2, "ryid");
            return (Criteria) this;
        }

        public Criteria andTpdzIsNull() {
            addCriterion("tpdz is null");
            return (Criteria) this;
        }

        public Criteria andTpdzIsNotNull() {
            addCriterion("tpdz is not null");
            return (Criteria) this;
        }

        public Criteria andTpdzEqualTo(String value) {
            addCriterion("tpdz =", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzNotEqualTo(String value) {
            addCriterion("tpdz <>", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzGreaterThan(String value) {
            addCriterion("tpdz >", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzGreaterThanOrEqualTo(String value) {
            addCriterion("tpdz >=", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzLessThan(String value) {
            addCriterion("tpdz <", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzLessThanOrEqualTo(String value) {
            addCriterion("tpdz <=", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzLike(String value) {
            addCriterion("tpdz like", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzNotLike(String value) {
            addCriterion("tpdz not like", value, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzIn(List<String> values) {
            addCriterion("tpdz in", values, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzNotIn(List<String> values) {
            addCriterion("tpdz not in", values, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzBetween(String value1, String value2) {
            addCriterion("tpdz between", value1, value2, "tpdz");
            return (Criteria) this;
        }

        public Criteria andTpdzNotBetween(String value1, String value2) {
            addCriterion("tpdz not between", value1, value2, "tpdz");
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