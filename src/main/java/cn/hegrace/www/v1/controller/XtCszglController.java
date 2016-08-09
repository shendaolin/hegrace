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
import cn.hegrace.www.v1.dao.pojo.XtCszgl;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtCszglSeach;
import net.sf.json.JSONObject;

@Controller
public class XtCszglController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	
	@RequestMapping("raceManage/xtCszglList.html")
	public ModelAndView xtCszglList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("raceManage/xtCszglList");
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtCszglFlexigrid.html", method = RequestMethod.POST)
	public void xtCszglFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtCszglSeach xtCszglSeach = (XtCszglSeach) httpMessageConverter(new XtCszglSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtCszglSeach);
		Map map = flexigrid.getMap();
		map.put("ssmc", xtCszglSeach.getSsmc());
		map.put("ssid", xtCszglSeach.getSsid());
		map.put("xm", xtCszglSeach.getXm());
		flexigrid.setPages(xtCszglSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtCszgl.select_xtcszgl_count", map));
		flexigrid.setRows(baseService.queryForList("XtCszgl.select_xtcszgl_list", map));
		System.out.println(baseService.queryForList("XtCszgl.select_xtcszgl_list", map));
		
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtCszglEdit.html")
	public ModelAndView xtCszglEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtCszglEdit");
		String id = request.getParameter("id");
		XtGydmExample example1 = new XtGydmExample();
		example1.createCriteria().andLbidEqualTo(4);//证件类型
		List<XtGydm> list1 = baseService.selectByExample(example1);
		mv.addObject("XtDmbList1", list1);
		System.out.println(list1); 
		if(StringUtils.isNotEmpty(id)){
			XtCszgl xtCszgl = new XtCszgl();
			xtCszgl.setId(id);		 
			xtCszgl = baseService.selectByPrimaryKey(xtCszgl);
			mv.addObject("xtCszgl", xtCszgl);
		}
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtCszglSave.html")
	public void xtCszglSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtCszgl xtCszgl = (XtCszgl) httpMessageConverter(new XtCszgl(), request);
		if(StringUtils.isEmpty(xtCszgl.getId())){
			xtCszgl.setId(baseService.getUuid());
			baseService.insert(xtCszgl);
		}else{
			baseService.updateByPrimaryKey(xtCszgl);
		}
		sendJson(xtCszgl, response);
	}
	
	
	@RequestMapping("raceManage/xtCszglDelete.html")
	public void xtCszglDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		XtCszgl xtCszgl = new XtCszgl();
		xtCszgl.setId(id);
		baseService.deleteByPrimaryKey(xtCszgl);
	}
	
}
