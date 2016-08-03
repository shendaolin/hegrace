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
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.dao.pojo.XtCzyhExample;
import cn.hegrace.www.v1.dao.pojo.XtDmlb;
import cn.hegrace.www.v1.dao.pojo.XtDmlbExample;
import cn.hegrace.www.v1.dao.pojo.XtSsgl;
import cn.hegrace.www.v1.dao.pojo.XtSsglExample;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtCzyhSeach;
import cn.hegrace.www.v1.seach.XtCzyhSeach;
import net.sf.json.JSONObject;

@Controller
public class XtCzyhController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("xtManage/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtManage/index");
		return mv;
	}
	
	@RequestMapping("xtManage/zhList.html")
	public ModelAndView XtCzyhList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtManage/zhList");
		return mv;
	}
	
	
	@RequestMapping(value = "xtManage/xtCzyhFlexigrid.html", method = RequestMethod.POST)
	public void XtCzyhFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtCzyhSeach xtCzyhSeach = (XtCzyhSeach) httpMessageConverter(new XtCzyhSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtCzyhSeach);
		Map map = flexigrid.getMap();
		map.put("dlm", xtCzyhSeach.getDlm());
		flexigrid.setPages(xtCzyhSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtCzyh.select_xtczyh_count", map));
		flexigrid.setRows(baseService.queryForList("XtCzyh.select_xtczyh_list", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("xtManage/zhedit.html")
	public ModelAndView XtCzyhEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("xtManage/zhedit");
		String id = request.getParameter("id");
		XtSsglExample example = new XtSsglExample();
		List<XtSsgl> list = baseService.selectByExample(example);
		mv.addObject("XtSsgList", list);
		
		if(StringUtils.isNotEmpty(id)){
			XtCzyh xtCzyh = new XtCzyh();
			xtCzyh.setId(id);
			xtCzyh = baseService.selectByPrimaryKey(xtCzyh);
			mv.addObject("xtCzyh", xtCzyh);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtManage/xtCzyhSave.html")
	public void XtCzyhSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("dd23");
		XtCzyh xtCzyh = (XtCzyh) httpMessageConverter(new XtCzyh(), request);
		if(StringUtils.isEmpty(xtCzyh.getId())){
			xtCzyh.setId(baseService.getUuid());
			baseService.insert(xtCzyh);
		}else{
			baseService.updateByPrimaryKey(xtCzyh);
		}
		sendJson(xtCzyh, response);
	}
	
	
	@RequestMapping("xtManage/XtCzyhDelete.html")
	public void XtCzyhDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		XtCzyh xtCzyh = new XtCzyh();
		xtCzyh.setId(id);
		baseService.deleteByPrimaryKey(xtCzyh);
	}
	
}