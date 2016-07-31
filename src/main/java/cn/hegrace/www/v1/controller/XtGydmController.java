package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtGydmSeach;
import net.sf.json.JSONObject;

@Controller
public class XtGydmController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("xtcsManage/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/index");
		return mv;
	}
	
	@RequestMapping("xtcsManage/xtGydmList.html")
	public ModelAndView xtGydmList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmList");
		return mv;
	}
	
	
	@RequestMapping(value = "xtcsManage/xtGydmFlexigrid.html", method = RequestMethod.POST)
	public void xtGydmFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtGydmSeach xtGydmSeach = (XtGydmSeach) httpMessageConverter(new XtGydmSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtGydmSeach);
		Map map = flexigrid.getMap();
		map.put("lbmc", xtGydmSeach.getLbmc());
		flexigrid.setPages(xtGydmSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtGydm.select_xtgydm_count", map));
		flexigrid.setRows(baseService.queryForList("XtGydm.select_xtgydm_list", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("xtcsManage/xtGydmEdit.html")
	public ModelAndView xtGydmEdit(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmEdit");
		return mv;
	}
	
	@RequestMapping("xtcsManage/xtGydmView.html")
	public ModelAndView xtGydmView(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmView");
		return mv;
	}
	
	
	@RequestMapping("xtcsManage/xtGydmSave.html")
	public ModelAndView xtGydmSave(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmView");
		return mv;
	}
	
	@RequestMapping("xtcsManage/xtGydmDelete.html")
	public ModelAndView xtGydmDelete(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmList");
		return mv;
	}
	
}
