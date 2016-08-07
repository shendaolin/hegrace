package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.plexus.util.StringUtils;
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
import cn.hegrace.www.v1.dao.pojo.XtDmlb;
import cn.hegrace.www.v1.dao.pojo.XtDmlbExample;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtSsgl;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsglSeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsglController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("raceManage/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("raceManage/index");
		return mv;
	}
	
	@RequestMapping("raceManage/xtSsglList.html")
	public ModelAndView xtSsglList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("raceManage/xtSsglList");
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsglFlexigrid.html", method = RequestMethod.POST)
	public void xtSsglFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsglSeach xtSsglSeach = (XtSsglSeach) httpMessageConverter(new XtSsglSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsglSeach);
		Map map = flexigrid.getMap();
		map.put("ssmc", xtSsglSeach.getSsmc());
		flexigrid.setPages(xtSsglSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("select_xtssgl_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsgl.select_xtssgl_list", map));
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsglEdit.html")
	public ModelAndView xtSsglEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsglEdit");
		String id = request.getParameter("id");
		if(StringUtils.isNotEmpty(id)){
			XtSsgl xtSsgl = new XtSsgl();
			xtSsgl.setId(id);
			xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
			mv.addObject("xtSsgl", xtSsgl);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtSsglSave.html")
	public void xtSsglSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsgl xtSsgl = (XtSsgl) httpMessageConverter(new XtSsgl(), request);
		if(StringUtils.isEmpty(xtSsgl.getId())){
			xtSsgl.setId(baseService.getUuid());
			baseService.insert(xtSsgl);
		}else{
			baseService.updateByPrimaryKey(xtSsgl);
		}
		sendJson(xtSsgl, response);
	}
	
	
	@RequestMapping("raceManage/xtSsglDelete.html")
	public void xtSsglDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(id);
		baseService.deleteByPrimaryKey(xtSsgl);
	}
	
}
