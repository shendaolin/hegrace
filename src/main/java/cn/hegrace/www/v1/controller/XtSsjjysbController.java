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
import cn.hegrace.www.v1.dao.pojo.XtBsysb;
import cn.hegrace.www.v1.dao.pojo.XtBsysbExample;
import cn.hegrace.www.v1.dao.pojo.XtDmlb;
import cn.hegrace.www.v1.dao.pojo.XtDmlbExample;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtSsgl;
import cn.hegrace.www.v1.dao.pojo.XtSsjjy;
import cn.hegrace.www.v1.dao.pojo.XtSsjjysb;
import cn.hegrace.www.v1.dao.pojo.XtSsjjysbExample;
import cn.hegrace.www.v1.dto.XtSsjjysbDto;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsjjysbSeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsjjysbController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	 
	
	@RequestMapping("raceManage/xtSsjjysbList.htm")
	public ModelAndView xtSsjjysbList(HttpServletRequest request,
			HttpServletResponse response) throws Exception{ 
		String ssid = request.getParameter("ssid");
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjysbList");
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsjjysbFlexigrid.htm", method = RequestMethod.POST)
	public void xtSsjjysbFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjysbSeach xtSsjjysbSeach = (XtSsjjysbSeach) httpMessageConverter(new XtSsjjysbSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsjjysbSeach);
		Map map = flexigrid.getMap();
		String ssid = request.getParameter("ssid");
		map.put("ssid", ssid);
		flexigrid.setPages(xtSsjjysbSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsjjysb.select_xtssjjysb_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjysb.select_xtssjjysb_list", map));
		sendJson(flexigrid, response);
	 }
	
	
	@RequestMapping("raceManage/xtSsjjysbEdit.htm")
	public void xtSsjjysbEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjysb xtSsjjysb = (XtSsjjysb) httpMessageConverter(new XtSsjjysb(), request);
		XtSsjjysb xtSsjjysb2 = baseService.selectByPrimaryKey(xtSsjjysb);
		xtSsjjysb.setSsjjyid(xtSsjjysb2.getSsjjyid());
		xtSsjjysb.setSbid(xtSsjjysb2.getSbid());
		baseService.updateByPrimaryKey(xtSsjjysb);
	}
	
	@RequestMapping("raceManage/xtSsjjysbDelete.htm")
	public void xtSsjjysbDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjysb xtSsjjysb = (XtSsjjysb) httpMessageConverter(new XtSsjjysb(), request);
		baseService.deleteByPrimaryKey(xtSsjjysb);
	}
}
