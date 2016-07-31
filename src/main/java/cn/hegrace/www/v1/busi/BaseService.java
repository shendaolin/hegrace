package cn.hegrace.www.v1.busi;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hegrace.www.v1.dao.pojo.BaseDao;
import cn.hegrace.www.v1.dao.pojo.BaseExample;

@Transactional
public class BaseService extends SqlSessionTemplate {

	public BaseService(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
		// TODO Auto-generated constructor stub
	}

	public String getUuid(){
		return super.selectOne("Groble.getUuid", null);
	}
	
	public String getNamespace(BaseDao parameter){
		return parameter.getClass().getSimpleName();
	}
	
	public String getNamespace(BaseExample parameter){
		String namespace = parameter.getClass().getSimpleName();
		return namespace.replaceAll("Example", "");
	}
	
	public <T> T selectByPrimaryKey(BaseDao parameter) throws Exception {
		// TODO Auto-generated method stub
		return super.selectOne(getNamespace(parameter) + ".selectByPrimaryKey", parameter.getPrimaryKeyValue());
	}

	public int queryForCount(String sqlid, Object parameter) {
		// TODO Auto-generated method stub
		return super.selectOne(sqlid, parameter);
	}
	
	public Object[] queryForList(String sqlid, Object parameter) {
		// TODO Auto-generated method stub
		List list = super.selectList(sqlid, parameter);
		if(CollectionUtils.isNotEmpty(list)){
			return list.toArray();
		}
		return null;
	}
	
	public <E> List<E> selectByExample(BaseExample parameter) {
		// TODO Auto-generated method stub
		return super.selectList(getNamespace(parameter) +".selectByExample", parameter);
	}

	public int deleteByPrimaryKey(BaseDao parameter) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(getNamespace(parameter)  + ".deleteByPrimaryKey", parameter.getPrimaryKeyValue());
	}

	public int deleteByExample(BaseExample parameter) {
		// TODO Auto-generated method stub
		return super.delete(getNamespace(parameter) + ".deleteByExample", parameter);
	}

	public int insert(BaseDao parameter) {
		// TODO Auto-generated method stub
		return super.insert(getNamespace(parameter) + ".insert", parameter);
	}

	public <T> T countByExample(BaseExample parameter) {
		// TODO Auto-generated method stub
		return super.selectOne(getNamespace(parameter) + ".countByExample", parameter);
	}

	public int updateByPrimaryKey(BaseDao parameter) throws Exception {
		// TODO Auto-generated method stub
		return super.update(getNamespace(parameter) +".updateByPrimaryKey", parameter);
	}
	
}
