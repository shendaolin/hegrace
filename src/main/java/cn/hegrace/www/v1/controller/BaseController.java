package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hegrace.www.v1.utils.StringUtils;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public abstract class BaseController {

	public void sendJson(Object object, HttpServletResponse response) {
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		try {
			out = response.getWriter();
			
			JsonConfig config = new JsonConfig();
			config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
			System.out.println(JSONObject.fromObject(object, config).toString());
			out.append(JSONObject.fromObject(object, config).toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public Object httpMessageConverter(Object object, HttpServletRequest request) throws Exception {

		Method[] methods = object.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("set")) {
				String[] values = request.getParameterValues(method.getName().replace("set", "").toLowerCase());
				if (values != null && values.length > 0) {
					method.invoke(object, StringUtils.parse(method.getParameterTypes()[0], StringUtils.join(values)));
				}
			}
		}
		System.out.println(JSONObject.fromObject(object).toString());
		return object;

	}

	public class DateJsonValueProcessor implements JsonValueProcessor {
		public static final String Default_DATE_PATTERN = "yyyy-MM-dd";
		private DateFormat dateFormat;

		public DateJsonValueProcessor(String datePattern) {
			try {
				dateFormat = new SimpleDateFormat(datePattern);
			} catch (Exception e) {
				dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);
			}
		}

		public Object processArrayValue(Object value, JsonConfig jsonConfig) {
			return process(value);
		}

		public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
			return process(value);
		}

		private Object process(Object value) {
			return dateFormat.format((java.util.Date) value);
		}
	}
}
