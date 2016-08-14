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
		System.out.println("ssidflex="+ssid);
		map.put("ssid", ssid);
		flexigrid.setPages(xtSsjjysbSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsjjysb.select_xtssjjysb_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjysb.select_xtssjjysb_list", map));
		System.out.println(baseService.queryForList("XtSsjjysb.select_xtssjjysb_list", map));
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsjjysbEdit.htm")
	public ModelAndView xtSsjjysbEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjysbEdit");
		String ssjjyid = request.getParameter("ssjjyid");
		String ssid = request.getParameter("ssid");
		System.out.println("ssid="+ssid);	
		List<XtSsjjysbDto> list= baseService.selectList("XtSsjjysb.select_xtssjyxm_list", ssid);
		mv.addObject("XtSsjjysbList", list);
		XtBsysbExample example = new XtBsysbExample();
		example.createCriteria().andSbztEqualTo(1);
		List<XtBsysb> list1 = baseService.selectByExample(example);
		XtSsgl xtSsgl = new XtSsgl();
		if(StringUtils.isNotEmpty(ssjjyid)){
			XtSsjjysb xtSsjjysb = new XtSsjjysb();
			xtSsjjysb = baseService.selectByPrimaryKey(xtSsjjysb);
			mv.addObject("xtSsjjysb", xtSsjjysb);
			XtSsjjy stssjjy = new XtSsjjy();
			stssjjy.setId(ssjjyid);
			stssjjy = baseService.selectByPrimaryKey(stssjjy);
			ssid=stssjjy.getSsid();
			System.out.println("ssid44="+ssid);
		
		}
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		mv.addObject("XtBsysbList", list1);
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtSsjjysbSave.htm")
	public void xtSsjjysbSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjysb xtSsjjysb = (XtSsjjysb) httpMessageConverter(new XtSsjjysb(), request);
		if(StringUtils.isEmpty(xtSsjjysb.getSsjjyid())){
			//xtSsjjysb.setId(baseService.getUuid());
			baseService.insert(xtSsjjysb);
		}else{
			baseService.updateByPrimaryKey(xtSsjjysb);
		}
		sendJson(xtSsjjysb, response);
	}
	
	
	@RequestMapping("raceManage/xtSsjjysbDelete.htm")
	public void xtSsjjysbDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		XtSsjjysb xtSsjjysb = new XtSsjjysb();
		//xtSsjjysb.setId(id);
		//baseService.deleteByPrimaryKey(xtSsjjysb);
	}
	
}
