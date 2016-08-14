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
import cn.hegrace.www.v1.dao.pojo.XtBsysb;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtBsysbSeach;
import net.sf.json.JSONObject;

@Controller
public class XtBsysbController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("xtbsysbManage/index.htm")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtbsysbManage/index");
		return mv;
	}
	
	@RequestMapping("xtbsysbManage/xtBsysbList.htm")
	public ModelAndView xtBsysbList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtbsysbManage/xtBsysbList");
		return mv;
	}
	
	
	@RequestMapping(value = "xtbsysbManage/xtBsysbFlexigrid.htm", method = RequestMethod.POST)
	public void xtBsysbFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtBsysbSeach xtBsysbSeach = (XtBsysbSeach) httpMessageConverter(new XtBsysbSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtBsysbSeach);
		Map map = flexigrid.getMap();
		map.put("lbmc", xtBsysbSeach.getLbmc());
		flexigrid.setPages(xtBsysbSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtBsysb.select_xtbsysb_count", map));
		flexigrid.setRows(baseService.queryForList("XtBsysb.select_xtbsysb_list", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("xtbsysbManage/xtBsysbEdit.htm")
	public ModelAndView xtBsysbEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("xtbsysbManage/xtBsysbEdit");
		String id = request.getParameter("id");
		XtGydmExample example = new XtGydmExample();
		example.createCriteria().andLbidEqualTo(2);
		List<XtGydm> list = baseService.selectByExample(example);
		mv.addObject("XtDmbList", list);
		System.out.println(id);
		if(StringUtils.isNotEmpty(id)){
			XtBsysb xtBsysb = new XtBsysb();
			xtBsysb.setId(id);
			xtBsysb = baseService.selectByPrimaryKey(xtBsysb);
			mv.addObject("xtBsysb", xtBsysb);
			System.out.println(xtBsysb);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtbsysbManage/xtBsysbSave.htm")
	public void xtBsysbSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtBsysb xtBsysb = (XtBsysb) httpMessageConverter(new XtBsysb(), request);
		if(StringUtils.isEmpty(xtBsysb.getId())){
			xtBsysb.setId(baseService.getUuid());
			baseService.insert(xtBsysb);
		}else{
			baseService.updateByPrimaryKey(xtBsysb);
		}
		sendJson(xtBsysb, response);
	}
	
	
	@RequestMapping("xtbsysbManage/xtBsysbDelete.htm")
	public void xtBsysbDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		XtBsysb xtBsysb = new XtBsysb();
		xtBsysb.setId(id);
		baseService.deleteByPrimaryKey(xtBsysb);
	}
	
}
