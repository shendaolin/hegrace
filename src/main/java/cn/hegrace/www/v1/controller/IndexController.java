package cn.hegrace.www.v1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseController {
	
	@RequestMapping("/header.html")
	public ModelAndView header(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("header");
		return mv;
	}
	
	@RequestMapping("/footer.html")
	public ModelAndView footer(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("footer");
		return mv;
	}
	
	
	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
