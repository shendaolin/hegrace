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
import cn.hegrace.www.v1.dao.pojo.XtSsgw;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsgwSeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsgwController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	 
	
	@RequestMapping("raceManage/xtSsgwList.html")
	public ModelAndView xtSsgwList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("raceManage/xtSsgwList");
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsgwFlexigrid.html", method = RequestMethod.POST)
	public void xtSsgwFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsgwSeach xtSsgwSeach = (XtSsgwSeach) httpMessageConverter(new XtSsgwSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsgwSeach);
		Map map = flexigrid.getMap();
		map.put("ssmc", xtSsgwSeach.getSsmc());
		map.put("zt", xtSsgwSeach.getZt());
		flexigrid.setPages(xtSsgwSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsgw.select_xtssgl_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsgw.select_xtssgl_list", map));
		System.out.println(baseService.queryForList("XtSsgw.select_xtssgl_list", map));
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsgwEdit.html")
	public ModelAndView xtSsgwEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsgwEdit");
		String id = request.getParameter("id");
		String zt = request.getParameter("zt");
		int zt1=0;
		if(StringUtils.isNotEmpty(zt)){
			zt1 = Integer.parseInt(zt);
		}else{
			zt1=0;
		}
		if(StringUtils.isNotEmpty(id)){
			XtSsgw xtSsgw = new XtSsgw();
			xtSsgw.setId(id);
			//xtSsgw.setZt(zt1);
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
	@RequestMapping("raceManage/xtSsgwSave.html")
	public void xtSsgwSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsgw xtSsgw = (XtSsgw) httpMessageConverter(new XtSsgw(), request);
		if(StringUtils.isEmpty(xtSsgw.getId())){
			xtSsgw.setId(baseService.getUuid());
			baseService.insert(xtSsgw);
		}else{
			baseService.updateByPrimaryKey(xtSsgw);
		}
		sendJson(xtSsgw, response);
	}
	
	
	@RequestMapping("raceManage/xtSsgwDelete.html")
	public void xtSsgwDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		XtSsgw xtSsgw = new XtSsgw();
		xtSsgw.setId(id);
		baseService.deleteByPrimaryKey(xtSsgw);
	}
	
}
