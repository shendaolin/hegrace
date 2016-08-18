package cn.hegrace.www.v1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.dao.pojo.XtCzyhExample;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample.Criteria;
import cn.hegrace.www.v1.seach.XtGydmSeach;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private BaseService baseService;
	

	@RequestMapping("/login.htm")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	@RequestMapping("/check.htm")
	public ModelAndView check(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("login");
		XtCzyh xtCzyh = (XtCzyh) httpMessageConverter(new XtCzyh(), request);
		XtCzyhExample example = new XtCzyhExample();
		example.createCriteria().andDlmEqualTo(xtCzyh.getDlm());
		example.createCriteria().andDlmmEqualTo(xtCzyh.getDlmm());
		List<XtCzyh> list = baseService.selectByExample(example);
		
		if(list != null && !list.isEmpty()){
			xtCzyh = list.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("xtCzyh", xtCzyh);
			if(StringUtils.isNotEmpty(xtCzyh.getSsid())){
				response.sendRedirect("index.htm");
			}else{
				response.sendRedirect("raceManage/index.htm");
			}
		}else{
			mv.addObject("xtCzyh", xtCzyh);
			mv.addObject("error", "登录失败，请检查账号密码是否正确！");
		}
		return mv;
	}
	
	
	

}
