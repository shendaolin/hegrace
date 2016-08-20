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
import cn.hegrace.www.v1.dao.pojo.XtJjry;
import cn.hegrace.www.v1.dao.pojo.XtJjryzz;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtJjryzzSeach;
import net.sf.json.JSONObject;

@Controller
public class XtJjryzzController extends BaseController {

	@Autowired
	private BaseService baseService;
	@RequestMapping("xtjjryManage/xtJjryzzList.htm")
	public ModelAndView xtJjryzzList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtJjryzzList");
		String ryid = request.getParameter("ryid");
		System.out.println("ryid=" + ryid);
		XtJjry xtJjry = new XtJjry();
		xtJjry.setId(ryid);
		xtJjry = baseService.selectByPrimaryKey(xtJjry);
		mv.addObject("xtJjry", xtJjry);
		mv.addObject("ryid", ryid);
		return mv;
	}

	@RequestMapping(value = "xtjjryManage/xtJjryzzFlexigrid.htm", method = RequestMethod.POST)
	public void xtJjryzzFlexigrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		XtJjryzzSeach xtJjryzzSeach = (XtJjryzzSeach) httpMessageConverter(new XtJjryzzSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtJjryzzSeach);
		Map map = flexigrid.getMap();
		map.put("xm", xtJjryzzSeach.getXm());
		flexigrid.setPages(xtJjryzzSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtJjryzz.select_xtjjryzz_count", map));
		flexigrid.setRows(baseService.queryForList("XtJjryzz.select_xtjjryzz_list", map));
		sendJson(flexigrid, response);
	}

	@RequestMapping("xtjjryManage/xtJjryzzEdit.htm")
	public ModelAndView xtJjryzzEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtJjryzzEdit");
		String ryid = request.getParameter("ryid");
		System.out.println("ryidedit=" + ryid);
		XtJjry xtJjry = new XtJjry();
		xtJjry.setId(ryid);
		xtJjry = baseService.selectByPrimaryKey(xtJjry);
		mv.addObject("xtJjry", xtJjry);
		/*String id = request.getParameter("id");
		XtGydmExample example = new XtGydmExample();
		example.createCriteria().andLbidEqualTo(3);// 身份类型
		List<XtGydm> list = baseService.selectByExample(example);
		mv.addObject("XtDmbList", list);
		XtGydmExample example1 = new XtGydmExample();
		example1.createCriteria().andLbidEqualTo(4);// 证件类型
		List<XtGydm> list1 = baseService.selectByExample(example1);
		mv.addObject("XtDmbList1", list1);
		System.out.println(list1);
		if (StringUtils.isNotEmpty(id)) {
			XtJjryzz xtJjryzz = new XtJjryzz();
			xtJjryzz.setId(id);
			xtJjryzz = baseService.selectByPrimaryKey(xtJjryzz);
			mv.addObject("xtJjryzz", xtJjryzz);
		}
*/
		return mv;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtjjryManage/xtJjryzzSave.htm")
	public void xtJjryzzSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		XtJjryzz xtJjryzz = (XtJjryzz) httpMessageConverter(new XtJjryzz(), request);
		/*if (StringUtils.isEmpty(xtJjryzz.getId())) {
			xtJjryzz.setId(baseService.getUuid());
			baseService.insert(xtJjryzz);
		} else {
			baseService.updateByPrimaryKey(xtJjryzz);
		}*/
		sendJson(xtJjryzz, response);
	}

	@RequestMapping("xtjjryManage/xtJjryzzDelete.htm")
	public void xtJjryzzDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		XtJjryzz xtJjryzz = new XtJjryzz();
		xtJjryzz.setRyid(id);
		baseService.deleteByPrimaryKey(xtJjryzz);
	}

}
