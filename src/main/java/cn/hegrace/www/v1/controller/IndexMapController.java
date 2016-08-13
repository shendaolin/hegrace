package cn.hegrace.www.v1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hegrace.www.v1.busi.BaseService;
import cn.hegrace.www.v1.dao.pojo.XtCzyh;
import cn.hegrace.www.v1.dao.pojo.XtGydm;
import cn.hegrace.www.v1.dao.pojo.XtQjjl;
import cn.hegrace.www.v1.dao.pojo.XtSsjjy;
import cn.hegrace.www.v1.dao.pojo.XtSsjl;
import cn.hegrace.www.v1.dto.XtQjjlDto;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.Page;

@Controller
public class IndexMapController extends BaseController {

	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/getJjryLngLats.html")
	public void getJjryLngLats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyh");
		String ssid = "7eb491aa-5dbb-11e6-b84a-00163e0003f4";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setRows(baseService.queryForList("XtSsjjy.select_getJjryLngLats_list", map));
		sendJson(flexigrid, response);
	}
	
	@RequestMapping("/getQJJLLngLats.html")
	public void getQJJLLngLats(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyh");
		String ssid = "7eb491aa-5dbb-11e6-b84a-00163e0003f4";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		Page page = (Page) httpMessageConverter(new Page(), request);
		Flexigrid flexigrid = new Flexigrid(page);
		Map map = flexigrid.getMap();
		map.put("ssid", ssid);
		flexigrid.setRows(baseService.queryForList("XtQjjl.select_getQJJLLngLats_list", map));
		sendJson(flexigrid, response);
	}
	
	
	@RequestMapping("/getQJJLInfomation.html")
	public void getQJJLInfomation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qjid = request.getParameter("qjid");
		Flexigrid flexigrid = new Flexigrid(new Page());
		if(StringUtils.isNotEmpty(qjid)){
			Map map = new HashMap();
			map.put("qjid", qjid);
			flexigrid.setRows(baseService.queryForList("XtQjjl.select_getQJJLInfomation_list", map));
		}
		sendJson(flexigrid, response);
	}
	
	
	@RequestMapping("/getJjryInfomation.html")
	public void getJjryInfomation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jjyid = request.getParameter("jjyid");
		Flexigrid flexigrid = new Flexigrid(new Page());
		if(StringUtils.isNotEmpty(jjyid)){
			Map map = new HashMap();
			map.put("jjyid", jjyid);
			flexigrid.setRows(baseService.queryForList("XtSsjjy.select_getJjryInfomation_list", map));
		}
		sendJson(flexigrid, response);
	}
	
	
	@RequestMapping("/automatic.html")
	public void automatic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		XtCzyh xtCzyh = (XtCzyh) session.getAttribute("xtCzyh");
		String ssid = "7eb491aa-5dbb-11e6-b84a-00163e0003f4";
		if(xtCzyh != null){
			ssid = xtCzyh.getSsid();
		}
		String ryid = request.getParameter("ryid");
		String qjid = request.getParameter("qjid");
		
		String[] ryids = ryid.split(",");
		
		for (String id : ryids) {
			XtSsjl xtSsjl = new XtSsjl();
			xtSsjl.setRyid(id);
			xtSsjl.setQjid(qjid);
			xtSsjl.setId(baseService.getUuid());
			xtSsjl.setSsid(ssid);
			xtSsjl.setZt(1);
			baseService.insert(xtSsjl);
		}
	}
	
	
	@RequestMapping("/closeQjjl.html")
	public void closeQjjl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qjid = request.getParameter("qjid");
		XtQjjl xtqjjl = new XtQjjl();
		if(StringUtils.isNotEmpty(qjid)){
			xtqjjl.setId(qjid);
			xtqjjl = baseService.selectByPrimaryKey(xtqjjl);
			xtqjjl.setZt("8");
			baseService.updateByPrimaryKey(xtqjjl);
		}
	}
	
	
	@RequestMapping("/cancelQjjl.html")
	public void cancelQjjl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qjid = request.getParameter("qjid");
		XtQjjl xtqjjl = new XtQjjl();
		if(StringUtils.isNotEmpty(qjid)){
			xtqjjl.setId(qjid);
			xtqjjl = baseService.selectByPrimaryKey(xtqjjl);
			xtqjjl.setZt("9");
			baseService.updateByPrimaryKey(xtqjjl);
		}
	}
	
	@RequestMapping("/allocation.html")
	public void allocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qjid = request.getParameter("qjid");
		String jjryid = request.getParameter("jjryid");
		XtSsjjy xtSsjjy = new XtSsjjy();
		if(StringUtils.isNotEmpty(jjryid)){
			xtSsjjy.setId(jjryid);
			xtSsjjy = baseService.selectByPrimaryKey(xtSsjjy);
			XtSsjl xtSsjl = new XtSsjl();
			xtSsjl.setId(baseService.getUuid());
			xtSsjl.setQjid(qjid);
			xtSsjl.setRyid(xtSsjjy.getRyid());
			xtSsjl.setSsid(xtSsjjy.getSsid());
			xtSsjl.setZt(0);
			baseService.insert(xtSsjl);
		}
	}
	
	
}
