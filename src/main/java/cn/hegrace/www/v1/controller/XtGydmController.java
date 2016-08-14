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
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtGydmSeach;
import net.sf.json.JSONObject;

@Controller
public class XtGydmController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("xtcsManage/index.htm")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/index");
		return mv;
	}
	
	@RequestMapping("xtcsManage/xtGydmList.htm")
	public ModelAndView xtGydmList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmList");
		return mv;
	}
	
	
	@RequestMapping(value = "xtcsManage/xtGydmFlexigrid.htm", method = RequestMethod.POST)
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
	
	@RequestMapping("xtcsManage/xtGydmEdit.htm")
	public ModelAndView xtGydmEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("xtcsManage/xtGydmEdit");
		String id = request.getParameter("id");
		XtDmlbExample example = new XtDmlbExample();
		List<XtDmlb> list = baseService.selectByExample(example);
		mv.addObject("xtDmlbList", list);
		
		if(StringUtils.isNotEmpty(id)){
			XtGydm xtGydm = new XtGydm();
			xtGydm.setId(id);
			xtGydm = baseService.selectByPrimaryKey(xtGydm);
			mv.addObject("xtGydm", xtGydm);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtcsManage/xtGydmSave.htm")
	public void xtGydmSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtGydm xtGydm = (XtGydm) httpMessageConverter(new XtGydm(), request);
		if(StringUtils.isEmpty(xtGydm.getId())){
			xtGydm.setId(baseService.getUuid());
			baseService.insert(xtGydm);
		}else{
			baseService.updateByPrimaryKey(xtGydm);
		}
		sendJson(xtGydm, response);
	}
	
	
	@RequestMapping("xtcsManage/xtGydmDelete.htm")
	public void xtGydmDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		XtGydm xtGydm = new XtGydm();
		xtGydm.setId(id);
		baseService.deleteByPrimaryKey(xtGydm);
	}
	
}
