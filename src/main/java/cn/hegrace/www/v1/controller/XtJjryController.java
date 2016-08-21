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
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtJjrySeach;
import net.sf.json.JSONObject;

@Controller
public class XtJjryController extends BaseController {

	@Autowired
	private BaseService baseService;

	@RequestMapping("xtjjryManage/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("xtjjryManage/index");
		return mv;
	}

	@RequestMapping("xtjjryManage/xtssjlList.htm")
	public ModelAndView xtssjlList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtssjlList");
		String ryid = request.getParameter("ryid");
		System.out.println("ryid=" + ryid);
		XtJjry xtJjry = new XtJjry();
		xtJjry.setId(ryid);
		xtJjry = baseService.selectByPrimaryKey(xtJjry);
		mv.addObject("xtJjry", xtJjry);
		mv.addObject("ryid", ryid);
		return mv;
	}

	@RequestMapping(value = "xtjjryManage/xtssjlFlexigrid.htm", method = RequestMethod.POST)
	public void xtssjlFlexigrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		XtJjrySeach xtssjlSeach = (XtJjrySeach) httpMessageConverter(new XtJjrySeach(), request);
		System.out.println("xtssjlSeach=" +  xtssjlSeach);
		Flexigrid flexigrid = new Flexigrid(xtssjlSeach);
		Map map = flexigrid.getMap();
		System.out.println("ryid1=" +  xtssjlSeach.getRyid());
		map.put("ryid",xtssjlSeach.getRyid());
		map.put("ssmc", xtssjlSeach.getSsmc());
		flexigrid.setPages(xtssjlSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtJjry.select_xtssjl_count", map));
		flexigrid.setRows(baseService.queryForList("XtJjry.select_xtssjl_list", map));
		sendJson(flexigrid, response);
	}

	@RequestMapping("xtjjryManage/xtJjryList.htm")
	public ModelAndView xtJjryList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtJjryList");
		return mv;
	}

	@RequestMapping(value = "xtjjryManage/xtJjryFlexigrid.htm", method = RequestMethod.POST)
	public void xtJjryFlexigrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		XtJjrySeach xtJjrySeach = (XtJjrySeach) httpMessageConverter(new XtJjrySeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtJjrySeach);
		Map map = flexigrid.getMap();
		map.put("xm", xtJjrySeach.getXm());
		flexigrid.setPages(xtJjrySeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtJjry.select_xtjjry_count", map));
		flexigrid.setRows(baseService.queryForList("XtJjry.select_xtjjry_list", map));
		sendJson(flexigrid, response);
	}

	@RequestMapping("xtjjryManage/xtJjryEdit.htm")
	public ModelAndView xtJjryEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtJjryEdit");
		String id = request.getParameter("id");
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
			XtJjry xtJjry = new XtJjry();
			xtJjry.setId(id);
			xtJjry = baseService.selectByPrimaryKey(xtJjry);
			mv.addObject("xtJjry", xtJjry);
		}

		return mv;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtjjryManage/xtJjrySave.htm")
	public void xtJjrySave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		XtJjry xtJjry = (XtJjry) httpMessageConverter(new XtJjry(), request);
		if (StringUtils.isEmpty(xtJjry.getId())) {
			xtJjry.setId(baseService.getUuid());
			baseService.insert(xtJjry);
		} else {
			baseService.updateByPrimaryKey(xtJjry);
		}
		sendJson(xtJjry, response);
	}

	@RequestMapping("xtjjryManage/xtJjryDelete.htm")
	public void xtJjryDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		XtJjry xtJjry = new XtJjry();
		xtJjry.setId(id);
		baseService.deleteByPrimaryKey(xtJjry);
	}

}
