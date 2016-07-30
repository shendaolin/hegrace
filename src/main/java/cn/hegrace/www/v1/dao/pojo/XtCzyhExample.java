package cn.hegrace.www.v1.dao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XtCzyhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XtCzyhExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDlmIsNull() {
            addCriterion("dlm is null");
            return (Criteria) this;
        }

        public Criteria andDlmIsNotNull() {
            addCriterion("dlm is not null");
            return (Criteria) this;
        }

        public Criteria andDlmEqualTo(String value) {
            addCriterion("dlm =", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotEqualTo(String value) {
            addCriterion("dlm <>", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmGreaterThan(String value) {
            addCriterion("dlm >", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmGreaterThanOrEqualTo(String value) {
            addCriterion("dlm >=", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLessThan(String value) {
            addCriterion("dlm <", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLessThanOrEqualTo(String value) {
            addCriterion("dlm <=", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLike(String value) {
            addCriterion("dlm like", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotLike(String value) {
            addCriterion("dlm not like", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmIn(List<String> values) {
            addCriterion("dlm in", values, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotIn(List<String> values) {
            addCriterion("dlm not in", values, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmBetween(String value1, String value2) {
            addCriterion("dlm between", value1, value2, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotBetween(String value1, String value2) {
            addCriterion("dlm not between", value1, value2, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNull() {
            addCriterion("dlmm is null");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNotNull() {
            addCriterion("dlmm is not null");
            return (Criteria) this;
        }

        public Criteria andDlmmEqualTo(String value) {
            addCriterion("dlmm =", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotEqualTo(String value) {
            addCriterion("dlmm <>", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThan(String value) {
            addCriterion("dlmm >", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThanOrEqualTo(String value) {
            addCriterion("dlmm >=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThan(String value) {
            addCriterion("dlmm <", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThanOrEqualTo(String value) {
            addCriterion("dlmm <=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLike(String value) {
            addCriterion("dlmm like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotLike(String value) {
            addCriterion("dlmm not like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmIn(List<String> values) {
            addCriterion("dlmm in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotIn(List<String> values) {
            addCriterion("dlmm not in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmBetween(String value1, String value2) {
            addCriterion("dlmm between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotBetween(String value1, String value2) {
            addCriterion("dlmm not between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andXmIsNull() {
            addCriterion("xm is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("xm is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("xm =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("xm <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("xm >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("xm >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("xm <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("xm <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("xm like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("xm not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("xm in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("xm not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("xm between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("xm not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andDhIsNull() {
            addCriterion("dh is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("dh is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(String value) {
            addCriterion("dh =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(String value) {
            addCriterion("dh <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(String value) {
            addCriterion("dh >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(String value) {
            addCriterion("dh >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(String value) {
            addCriterion("dh <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(String value) {
            addCriterion("dh <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLike(String value) {
            addCriterion("dh like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotLike(String value) {
            addCriterion("dh not like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<String> values) {
            addCriterion("dh in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<String> values) {
            addCriterion("dh not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(String value1, String value2) {
            addCriterion("dh between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(String value1, String value2) {
            addCriterion("dh not between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andZwIsNull() {
            addCriterion("zw is null");
            return (Criteria) this;
        }

        public Criteria andZwIsNotNull() {
            addCriterion("zw is not null");
            return (Criteria) this;
        }

        public Criteria andZwEqualTo(Long value) {
            addCriterion("zw =", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotEqualTo(Long value) {
            addCriterion("zw <>", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThan(Long value) {
            addCriterion("zw >", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThanOrEqualTo(Long value) {
            addCriterion("zw >=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThan(Long value) {
            addCriterion("zw <", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThanOrEqualTo(Long value) {
            addCriterion("zw <=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwIn(List<Long> values) {
            addCriterion("zw in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotIn(List<Long> values) {
            addCriterion("zw not in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwBetween(Long value1, Long value2) {
            addCriterion("zw between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotBetween(Long value1, Long value2) {
            addCriterion("zw not between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andSsIsNull() {
            addCriterion("ss is null");
            return (Criteria) this;
        }

        public Criteria andSsIsNotNull() {
            addCriterion("ss is not null");
            return (Criteria) this;
        }

        public Criteria andSsEqualTo(Long value) {
            addCriterion("ss =", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsNotEqualTo(Long value) {
            addCriterion("ss <>", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsGreaterThan(Long value) {
            addCriterion("ss >", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsGreaterThanOrEqualTo(Long value) {
            addCriterion("ss >=", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsLessThan(Long value) {
            addCriterion("ss <", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsLessThanOrEqualTo(Long value) {
            addCriterion("ss <=", value, "ss");
            return (Criteria) this;
        }

        public Criteria andSsIn(List<Long> values) {
            addCriterion("ss in", values, "ss");
            return (Criteria) this;
        }

        public Criteria andSsNotIn(List<Long> values) {
            addCriterion("ss not in", values, "ss");
            return (Criteria) this;
        }

        public Criteria andSsBetween(Long value1, Long value2) {
            addCriterion("ss between", value1, value2, "ss");
            return (Criteria) this;
        }

        public Criteria andSsNotBetween(Long value1, Long value2) {
            addCriterion("ss not between", value1, value2, "ss");
            return (Criteria) this;
        }

        public Criteria andCjrqIsNull() {
            addCriterion("cjrq is null");
            return (Criteria) this;
        }

        public Criteria andCjrqIsNotNull() {
            addCriterion("cjrq is not null");
            return (Criteria) this;
        }

        public Criteria andCjrqEqualTo(Date value) {
            addCriterionForJDBCDate("cjrq =", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("cjrq <>", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqGreaterThan(Date value) {
            addCriterionForJDBCDate("cjrq >", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cjrq >=", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqLessThan(Date value) {
            addCriterionForJDBCDate("cjrq <", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cjrq <=", value, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqIn(List<Date> values) {
            addCriterionForJDBCDate("cjrq in", values, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("cjrq not in", values, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cjrq between", value1, value2, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCjrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cjrq not between", value1, value2, "cjrq");
            return (Criteria) this;
        }

        public Criteria andCrjIsNull() {
            addCriterion("crj is null");
            return (Criteria) this;
        }

        public Criteria andCrjIsNotNull() {
            addCriterion("crj is not null");
            return (Criteria) this;
        }

        public Criteria andCrjEqualTo(Long value) {
            addCriterion("crj =", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjNotEqualTo(Long value) {
            addCriterion("crj <>", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjGreaterThan(Long value) {
            addCriterion("crj >", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjGreaterThanOrEqualTo(Long value) {
            addCriterion("crj >=", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjLessThan(Long value) {
            addCriterion("crj <", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjLessThanOrEqualTo(Long value) {
            addCriterion("crj <=", value, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjIn(List<Long> values) {
            addCriterion("crj in", values, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjNotIn(List<Long> values) {
            addCriterion("crj not in", values, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjBetween(Long value1, Long value2) {
            addCriterion("crj between", value1, value2, "crj");
            return (Criteria) this;
        }

        public Criteria andCrjNotBetween(Long value1, Long value2) {
            addCriterion("crj not between", value1, value2, "crj");
            return (Criteria) this;
        }

        public Criteria andXgrqIsNull() {
            addCriterion("xgrq is null");
            return (Criteria) this;
        }

        public Criteria andXgrqIsNotNull() {
            addCriterion("xgrq is not null");
            return (Criteria) this;
        }

        public Criteria andXgrqEqualTo(Date value) {
            addCriterion("xgrq =", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqNotEqualTo(Date value) {
            addCriterion("xgrq <>", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqGreaterThan(Date value) {
            addCriterion("xgrq >", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqGreaterThanOrEqualTo(Date value) {
            addCriterion("xgrq >=", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqLessThan(Date value) {
            addCriterion("xgrq <", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqLessThanOrEqualTo(Date value) {
            addCriterion("xgrq <=", value, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqIn(List<Date> values) {
            addCriterion("xgrq in", values, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqNotIn(List<Date> values) {
            addCriterion("xgrq not in", values, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqBetween(Date value1, Date value2) {
            addCriterion("xgrq between", value1, value2, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrqNotBetween(Date value1, Date value2) {
            addCriterion("xgrq not between", value1, value2, "xgrq");
            return (Criteria) this;
        }

        public Criteria andXgrIsNull() {
            addCriterion("xgr is null");
            return (Criteria) this;
        }

        public Criteria andXgrIsNotNull() {
            addCriterion("xgr is not null");
            return (Criteria) this;
        }

        public Criteria andXgrEqualTo(Long value) {
            addCriterion("xgr =", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrNotEqualTo(Long value) {
            addCriterion("xgr <>", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrGreaterThan(Long value) {
            addCriterion("xgr >", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrGreaterThanOrEqualTo(Long value) {
            addCriterion("xgr >=", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrLessThan(Long value) {
            addCriterion("xgr <", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrLessThanOrEqualTo(Long value) {
            addCriterion("xgr <=", value, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrIn(List<Long> values) {
            addCriterion("xgr in", values, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrNotIn(List<Long> values) {
            addCriterion("xgr not in", values, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrBetween(Long value1, Long value2) {
            addCriterion("xgr between", value1, value2, "xgr");
            return (Criteria) this;
        }

        public Criteria andXgrNotBetween(Long value1, Long value2) {
            addCriterion("xgr not between", value1, value2, "xgr");
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