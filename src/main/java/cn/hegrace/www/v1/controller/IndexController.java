package cn.hegrace.www.v1.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.Page;

@Controller
public class IndexController extends BaseController {

	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/header.html")
	public ModelAndView header(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("header");
		return mv;
	}

	@RequestMapping("/footer.html")
	public ModelAndView footer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("footer");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/noSignIn.html")
	public void noSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyh");
		String ssid = "1";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}

		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtSsjjy.select_noSignIn_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjy.select_noSignIn_list", map));
		
		sendJson(flexigrid, response);
	}

}
