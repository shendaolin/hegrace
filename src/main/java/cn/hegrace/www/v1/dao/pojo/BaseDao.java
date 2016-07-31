package cn.hegrace.www.v1.dao.pojo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public abstract class BaseDao {

	public String getPrimaryKeyValue() throws Exception {

		String returnValue = "";
		// 返回对象所表示的类或接口的所有可访问公共方法
		Method[] methods = this.getClass().getMethods();
		for (Method m : methods) {
			PrimaryKey pk = m.getAnnotation(PrimaryKey.class);
			if (pk != null) {
				returnValue = (String) m.invoke(this);
			}
		}
		return returnValue;
	}

}
