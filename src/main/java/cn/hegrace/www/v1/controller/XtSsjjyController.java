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
import cn.hegrace.www.v1.dao.pojo.XtSsjjy;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsjjySeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsjjyController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	 
	@RequestMapping("raceManage/xtSsjjyList.htm")
	public ModelAndView xtSsjjyList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjyList");
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsjjyFlexigrid.htm", method = RequestMethod.POST)
	public void xtSsjjyFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjySeach xtSsjjySeach = (XtSsjjySeach) httpMessageConverter(new XtSsjjySeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsjjySeach);
		Map map = flexigrid.getMap();
		map.put("ssmc", xtSsjjySeach.getSsmc());
		map.put("zt", xtSsjjySeach.getZt());
		flexigrid.setPages(xtSsjjySeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsjjy.select_xtssgl_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjy.select_xtssgl_list", map));
		System.out.println(baseService.queryForList("XtSsjjy.select_xtssgl_list", map));
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsjjyEdit.htm")
	public ModelAndView xtSsjjyEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjyEdit");
		String id = request.getParameter("id");
		String zt = request.getParameter("zt");
		int zt1=0;
		if(StringUtils.isNotEmpty(zt)){
			zt1 = Integer.parseInt(zt);
		}else{
			zt1=0;
		}
		if(StringUtils.isNotEmpty(id)){
			XtSsjjy xtSsjjy = new XtSsjjy();
			xtSsjjy.setId(id);
			xtSsjjy.setZt(zt1);
			xtSsjjy = baseService.selectByPrimaryKey(xtSsjjy);
			mv.addObject("xtSsjjy", xtSsjjy);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtSsjjySave.htm")
	public void xtSsjjySave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjy xtSsjjy = (XtSsjjy) httpMessageConverter(new XtSsjjy(), request);
		if(StringUtils.isEmpty(xtSsjjy.getId())){
			xtSsjjy.setId(baseService.getUuid());
			baseService.insert(xtSsjjy);
		}else{
			baseService.updateByPrimaryKey(xtSsjjy);
		}
		sendJson(xtSsjjy, response);
	}
	
	
	@RequestMapping("raceManage/xtSsjjyDelete.htm")
	public void xtSsjjyDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		XtSsjjy xtSsjjy = new XtSsjjy();
		xtSsjjy.setId(id);
		baseService.deleteByPrimaryKey(xtSsjjy);
	}
	
}
