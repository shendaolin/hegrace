package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hegrace.www.v1.utils.StringUtils;
import net.sf.json.JSONObject;

public abstract class BaseController {

	public void sendJson(Object object, HttpServletResponse response){
		   PrintWriter out = null;
		   response.setCharacterEncoding("UTF-8");  
		   response.setContentType("application/json; charset=utf-8");  
		
		   try {  
		        out = response.getWriter();  
		        System.out.println(JSONObject.fromObject(object).toString());
		        out.append(JSONObject.fromObject(object).toString());   
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    } finally {  
		        if (out != null) {  
		            out.close();  
		        }  
		    }
	}
	
	public Object httpMessageConverter(Object object, HttpServletRequest request) throws Exception{
		
		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("set")){
				String[] values = request.getParameterValues(method.getName().replace("set", "").toLowerCase());
				if(values != null && values.length > 0){
					method.invoke(object, StringUtils.parse(method.getParameterTypes()[0], StringUtils.join(values)));
				}
			}
		}
		System.out.println(JSONObject.fromObject(object).toString());
		return  object;
		
	}
	
	
	
}
