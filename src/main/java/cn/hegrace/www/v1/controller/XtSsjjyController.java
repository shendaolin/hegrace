package cn.hegrace.www.v1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.util.CollectionUtils;
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
import cn.hegrace.www.v1.dao.pojo.XtJjry;
import cn.hegrace.www.v1.dao.pojo.XtSsgl;
import cn.hegrace.www.v1.dao.pojo.XtSsgw;
import cn.hegrace.www.v1.dao.pojo.XtSsjjy;
import cn.hegrace.www.v1.dao.pojo.XtSsjjysb;
import cn.hegrace.www.v1.dao.pojo.XtSsjjysbExample;
import cn.hegrace.www.v1.dto.XtBsysbDto;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtSsjjySeach;
import net.sf.json.JSONObject;

@Controller
public class XtSsjjyController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	 
	@RequestMapping("raceManage/xtSsjjyList.htm")
	public ModelAndView xtSsjjyList(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjyList");
		String ssid = request.getParameter("ssid");
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		mv.addObject("ssid", ssid);
		return mv;
	}
	
	
	@RequestMapping(value = "raceManage/xtSsjjyFlexigrid.htm", method = RequestMethod.POST)
	public void xtSsjjyFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjySeach xtSsjjySeach = (XtSsjjySeach) httpMessageConverter(new XtSsjjySeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtSsjjySeach);
		Map map = flexigrid.getMap();
		map.put("xm", xtSsjjySeach.getXm());
		map.put("ssid", xtSsjjySeach.getSsid());
		flexigrid.setPages(xtSsjjySeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtSsjjy.select_xtssgl_count1", map));
		flexigrid.setRows(baseService.queryForList("XtSsjjy.select_xtssgl_list1", map));
		sendJson(flexigrid, response);
	 }
	
	@RequestMapping("raceManage/xtSsjjyEdit.htm")
	public ModelAndView xtSsjjyEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("raceManage/xtSsjjyEdit");
		String ssid = request.getParameter("ssid");
		String id = request.getParameter("id");
		String ryxm = request.getParameter("ryxm");
		XtSsgl xtSsgl = new XtSsgl();
		xtSsgl.setId(ssid);
		xtSsgl = baseService.selectByPrimaryKey(xtSsgl);
		mv.addObject("xtSsgl", xtSsgl);
		mv.addObject("ssid", ssid);
		mv.addObject("ryxm", ryxm);
		List<String> jjysbid = new ArrayList<String>();
		if(StringUtils.isNotEmpty(id)){
			XtSsjjy xtSsjjy = new XtSsjjy();
			xtSsjjy.setId(id);
			xtSsjjy = baseService.selectByPrimaryKey(xtSsjjy);
			mv.addObject("xtSsjjy", xtSsjjy);
			
			XtSsjjysbExample example = new XtSsjjysbExample();
			example.createCriteria().andSsjjyidEqualTo(id);
			List<XtSsjjysb> xtSsjjysbs = baseService.selectByExample(example);
			String sbids = "";
			
			if(!CollectionUtils.isEmpty(xtSsjjysbs)){
				sbids += ",";
				for (XtSsjjysb xtSsjjysb : xtSsjjysbs) {
					sbids += xtSsjjysb.getSbid();
					sbids += ",";
					jjysbid.add("'" + xtSsjjysb.getId() + "'");
				}
			}
			mv.addObject("sbids", sbids);
		}
		

		Map map = new HashMap();
		map.put("ssid", ssid);
		List<XtJjry> xtJjrys = baseService.selectList("XtSsjjy.select_xtJjrys_list", map);
		mv.addObject("xtJjrys", xtJjrys);
		List<XtSsgw> xtSsgws = baseService.selectList("XtSsgw.select_xtSsgws_list", map);
		mv.addObject("xtSsgws", xtSsgws);
		if(!CollectionUtils.isEmpty(jjysbid)){
			map.put("jjysbid", StringUtils.join(jjysbid.toArray(), ","));
		}
		List<XtBsysbDto> xtBsysbDtos = baseService.selectList("XtBsysb.select_xtbsysbAll_list", map);
		mv.addObject("xtBsysbDtos", xtBsysbDtos);
		
		return mv;
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("raceManage/xtSsjjySave.htm")
	public void xtSsjjySave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtSsjjy xtSsjjy = (XtSsjjy) httpMessageConverter(new XtSsjjy(), request);
		String[] sbids = request.getParameterValues("sbids");
		if(StringUtils.isEmpty(xtSsjjy.getId())){
			xtSsjjy.setId(baseService.getUuid());
			//xtSsjjy.setZt(1);
			baseService.insert(xtSsjjy);
		}else{
			XtSsjjy xtSsjjy2 = baseService.selectByPrimaryKey(xtSsjjy);
			xtSsjjy.setZb(xtSsjjy2.getZb());
			//xtSsjjy.setZt(xtSsjjy2.getZt());
			baseService.updateByPrimaryKey(xtSsjjy);
		}
		XtSsjjysbExample example = new XtSsjjysbExample();
		example.createCriteria().andSsjjyidEqualTo(xtSsjjy.getId());
		baseService.delete("XtSsjjysb.deleteByExample", example);
		if(sbids != null && sbids.length > 0){
			for (String sbid : sbids) {
				XtSsjjysb xtSsjjysb =  new XtSsjjysb();
				xtSsjjysb.setId(baseService.getUuid());
				xtSsjjysb.setSsjjyid(xtSsjjy.getId());
				xtSsjjysb.setSbid(sbid);
				xtSsjjysb.setZt(0);
				baseService.insert("XtSsjjysb.insert", xtSsjjysb);
			}
		}
		sendJson(xtSsjjy, response);
	}
	
	
	
	@RequestMapping("raceManage/xtSsjjyDelete.htm")
	public void xtSsjjyDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		XtSsjjy xtSsjjy = new XtSsjjy();
		xtSsjjy.setId(id);
		baseService.deleteByPrimaryKey(xtSsjjy);
		XtSsjjysbExample example = new XtSsjjysbExample();
		example.createCriteria().andSsjjyidEqualTo(id);
		baseService.delete("XtSsjjysb.deleteByExample", example);
		
	}
	
}
