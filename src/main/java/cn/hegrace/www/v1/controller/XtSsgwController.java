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
import cn.hegrace.www.v1.dao.pojo.XtSsgw;
import cn.hegrace.www.v1.dao.pojo.XtSsgwExample;
import cn.hegrace.www.v1.error.HegraceException;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsgwSeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsgwController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	
	@RequestMapping("raceManage/xtSsgwList.htm")
	public ModelAndView xtSsgwList(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsgwList");
		String ssid = request.getParameter("ssid");
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		mv.addObject("ssid", ssid);
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsgwFlexigrid.htm", method = RequestMethod.POST)
	public void xtSsgwFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsgwSeach xtSsgwSeach = (XtSsgwSeach) httpMessageConverter(new XtSsgwSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsgwSeach);
		Map map = flexigrid.getMap();
		map.put("ssmc", xtSsgwSeach.getSsmc());
		map.put("ssid", xtSsgwSeach.getSsid());
		map.put("xm", xtSsgwSeach.getGwmc());
		flexigrid.setPages(xtSsgwSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsgw.select_xtssgw_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsgw.select_xtssgw_list", map));
		System.out.println(baseService.queryForList("XtSsgw.select_xtssgw_list", map));
		
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsgwEdit.htm")
	public ModelAndView xtSsgwEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsgwEdit");
		String id = request.getParameter("id");
		String ssid = request.getParameter("ssid");
		System.out.println("aaa="+ssid);
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		if(StringUtils.isNotEmpty(id)){
			XtSsgw xtSsgw = new XtSsgw();
			xtSsgw.setId(id);		 
			xtSsgw = baseService.selectByPrimaryKey(xtSsgw);
			mv.addObject("xtSsgw", xtSsgw);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtSsgwSave.htm")
	public void xtSsgwSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsgw xtSsgw = (XtSsgw) httpMessageConverter(new XtSsgw(), request);
		System.out.println("gwsl="+xtSsgw.getGwsl());
		XtSsgwExample example = new XtSsgwExample();
		XtSsgwExample.Criteria c = example.createCriteria();
		c.andGwmcLike(xtSsgw.getGwmc());
		c.andSsidEqualTo(xtSsgw.getSsid());
		if(StringUtils.isEmpty(xtSsgw.getId())){
			List<XtSsgw> list = baseService.selectByExample(example);
			if(list != null && !list.isEmpty()){
				sendJson(new HegraceException(xtSsgw.getGwmc()+"岗位名称已存在！"), response);
				return;
			}
			xtSsgw.setId(baseService.getUuid());
			baseService.insert(xtSsgw);
		}else{
			c.andIdNotEqualTo(xtSsgw.getId());
			List<XtSsgw> list = baseService.selectByExample(example);
			if(list != null && !list.isEmpty()){
				sendJson(new HegraceException(xtSsgw.getGwmc()+"岗位名称已存在！"), response);
				return;
			}
			baseService.updateByPrimaryKey(xtSsgw);
		}
		sendJson(xtSsgw, response);
	}
	
	
	@RequestMapping("raceManage/xtSsgwDelete.htm")
	public void xtSsgwDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		XtSsgw xtSsgw = new XtSsgw();
		xtSsgw.setId(id);
		baseService.deleteByPrimaryKey(xtSsgw);
	}
	
}
