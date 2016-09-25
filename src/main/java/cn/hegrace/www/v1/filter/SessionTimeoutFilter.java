package cn.hegrace.www.v1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import cn.hegrace.www.v1.dao.pojo.XtCzyh;

public class SessionTimeoutFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		String uri = request.getRequestURI();
		ServletContext application = request.getServletContext();
		if(uri.indexOf("login.htm") > -1 || uri.indexOf("check.htm") > -1){
			arg2.doFilter(arg0, arg1);
		}else{
			HttpSession session = request.getSession();
			String sessionid = session.getId();
			XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
			
	        if(xtCzyh == null) {
	            throw new ServletException("timeout");
	        }else{
	        	String id = (String) application.getAttribute(xtCzyh.getId());
	        	if(StringUtils.isNotEmpty(id) && sessionid.equals(id)){
	        		arg2.doFilter(arg0, arg1);
	        	}else{
	        		throw new ServletException("timeout");
	        	}
	        }
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
