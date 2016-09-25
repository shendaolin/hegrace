package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import cn.hegrace.www.v1.dao.pojo.XtBsysb;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.dao.pojo.XtCzyhExample;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample.Criteria;
import cn.hegrace.www.v1.error.HegraceException;
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
	
	@RequestMapping("/error.htm")
	public void error(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		response.sendRedirect(request.getContextPath()+"/login.htm");
	}
	
	@RequestMapping("/indexPass.htm")
	public ModelAndView indexPass(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("indexPass");
		return mv;
	}
	
	
	@RequestMapping("/check.htm")
	public ModelAndView check(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("login");
		XtCzyh xtCzyh = (XtCzyh) httpMessageConverter(new XtCzyh(), request);
		XtCzyhExample example = new XtCzyhExample();
		XtCzyhExample.Criteria c = example.createCriteria();
		c.andDlmEqualTo(xtCzyh.getDlm());
		c.andDlmmEqualTo(xtCzyh.getDlmm());
		List<XtCzyh> list = baseService.selectByExample(example);
		
		if(list != null && !list.isEmpty()){
			xtCzyh = list.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("xtCzyhBean", xtCzyh);
			ServletContext application = request.getServletContext();
			application.setAttribute(xtCzyh.getId(), session.getId());
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
	@RequestMapping("/editPass.htm")
	public ModelAndView editPass(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("editPass");
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = null;
		if(session.getAttribute("xtCzyhBean") != null){
			xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
			System.out.println("xtCzyh="+xtCzyh.getXm());
		}else{
			mv.addObject("error", "用户未登陆");
		}
		mv.addObject("xtCzyh", xtCzyh);
		return mv;
	}
	
	@RequestMapping("/editPassSave.htm")
	public void editPassSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtCzyh xtCzyh = (XtCzyh) httpMessageConverter(new XtCzyh(), request); 
		String olddlmm = request.getParameter("olddlmm");
		XtCzyhExample example = new XtCzyhExample();
		XtCzyhExample.Criteria c = example.createCriteria();
		c.andDlmmEqualTo(olddlmm);
		System.out.println("olddlmm="+olddlmm);
		List<XtCzyh> list = baseService.selectByExample(example);
		if(list != null && !list.isEmpty()){
			XtCzyh xtCzyh2 = baseService.selectByPrimaryKey(xtCzyh);
			xtCzyh2.setDlmm(xtCzyh.getDlmm());
			baseService.updateByPrimaryKey(xtCzyh2);
		}else{
			sendJson(new HegraceException("密码修改失败，请检查账号旧密码是否正确！"), response);
			return;
		}
		
		//sendJson(XtCzyh, response);
	}
	
	

}
