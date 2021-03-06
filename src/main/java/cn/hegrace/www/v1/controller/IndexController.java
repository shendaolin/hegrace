package cn.hegrace.www.v1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtGydmExample;
import cn.hegrace.www.v1.dao.pojo.XtJjry;
import cn.hegrace.www.v1.dao.pojo.XtSsgl;
import cn.hegrace.www.v1.dao.pojo.XtSsglWithBLOBs;
import cn.hegrace.www.v1.dto.XtSsjjysbDto;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.Page;

@Controller
public class IndexController extends BaseController {

	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/header.htm")
	public ModelAndView header(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("header");
		return mv;
	}

	@RequestMapping("/footer.htm")
	public ModelAndView footer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("footer");
		return mv;
	}

	@RequestMapping("/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("index");
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		mv.addObject("xtCzyh", xtCzyh);
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		XtSsglWithBLOBs xtSsglWithBLOBs = new XtSsglWithBLOBs();
		xtSsglWithBLOBs.setId(ssid);
		xtSsglWithBLOBs = baseService.selectOne("XtSsgl.selectByPrimaryKey",xtSsglWithBLOBs);
		mv.addObject("xtSsglWithBLOBs", xtSsglWithBLOBs);
		return mv;
	}

	@RequestMapping("/noSignInCount.htm")
	public void noSignInCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtSsjjy.select_noSignIn_count", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("/noSignIn.htm")
	public void noSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtSsjjy.select_noSignIn_count", map));
		List<XtJjry> xtJjrys = baseService.selectList("XtSsjjy.select_noSignIn_list", map);
		
		//获取身份类型;
		XtGydmExample example = new XtGydmExample();
		example.createCriteria().andLbidEqualTo(3);
		List<XtGydm> list = baseService.selectByExample(example);
		Map<String ,String> xtGydmMap = new HashMap<String, String>();
		for(XtGydm xtGydm : list){
			xtGydmMap.put(xtGydm.getId(), xtGydm.getDmmc());
		}
		for (XtJjry xtJjry : xtJjrys) {
			xtJjry.setSflx(xtGydmMap.get(xtJjry.getSflx()));
		}
		flexigrid.setRows(xtJjrys.toArray());
		sendJson(flexigrid, response);
	}
	
	
	@RequestMapping("/nquipment.htm")
	public void equipment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtSsjjysb.select_equipment_count", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjysb.select_equipment_list", map));
		sendJson(flexigrid, response);
	}

	

	@RequestMapping("/processedCount.htm")
	public void processedCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtQjjl.select_processed_count", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("/processed.htm")
	public void processed(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtQjjl.select_processed_count", map));
		flexigrid.setRows(baseService.queryForList("XtQjjl.select_processed_list", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("/processingCount.htm")
	public void processingCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtQjjl.select_processing_count", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("/processing.htm")
	public void processing(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyhBean");
		String ssid = "";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setTotal(baseService.queryForCount("XtQjjl.select_processing_count", map));
		flexigrid.setRows(baseService.queryForList("XtQjjl.select_processing_list", map));
		sendJson(flexigrid, response);
	}

}
