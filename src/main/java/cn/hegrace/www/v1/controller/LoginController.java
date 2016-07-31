package cn.hegrace.www.v1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample.Criteria;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private BaseService baseService;
	

	@RequestMapping("/login.html")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView("login");
//		XtGydmExample example = new XtGydmExample();
//		Criteria criterion = example.createCriteria();
//				criterion.andIdEqualTo("1");
//		List<XtGydm> xtgydms = baseService.selectByExample(example);
//		mv.addObject("xtgydms", xtgydms);
		return mv;
	}

}
