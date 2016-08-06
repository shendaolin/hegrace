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
import cn.hegrace.www.v1.dao.pojo.XtYjfk;
import cn.hegrace.www.v1.seach.Flexigrid;
import cn.hegrace.www.v1.seach.XtYjfkSeach;
import net.sf.json.JSONObject;

@Controller
public class XtYjfkController extends BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("xtyjfkManage/index.html")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtyjfkManage/index");
		return mv;
	}
	
	@RequestMapping("xtyjfkManage/xtYjfkList.html")
	public ModelAndView xtYjfkList(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mv = new ModelAndView("xtyjfkManage/xtYjfkList");
		
		return mv;
	}
	
	
	
	@RequestMapping(value="xtyjfkManage/yjfkFlexigrid.html", method = RequestMethod.POST)
	public void yjfkFlexigrid(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		XtYjfkSeach xtYjfkSeach = (XtYjfkSeach) httpMessageConverter(new XtYjfkSeach(), request);
		Flexigrid flexigrid = new Flexigrid(xtYjfkSeach);
		Map map = flexigrid.getMap();
		map.put("xm", xtYjfkSeach.getXm());
		flexigrid.setPages(xtYjfkSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtYjfkdm.select_xtyjfk_count", map));
		flexigrid.setRows(baseService.queryForList("XtYjfkdm.select_xtyjfk_list", map));
		sendJson(flexigrid, response);
	}
	
	/*@RequestMapping("yjfkManage/fkEdit.html")
	public ModelAndView fkEdit(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("yjfkManage/fkEdit");
		String id = request.getParameter("id");
		XtDmlbExample example = new XtDmlbExample();
		List<XtDmlb> list = baseService.selectByExample(example);
		mv.addObject("xtDmlbList", list);
		
		if(StringUtils.isNotEmpty(id)){
			XtYjfk fk = new XtYjfk();
			fk.setId(id);
			fk = baseService.selectByPrimaryKey(fk);
			mv.addObject("fk", fk);
		}
		
		return mv;
	}
	*/
	
	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	/*@RequestMapping("yjfkManage/fkSave.html")
	public void fkSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		fk fk = (fk) httpMessageConverter(new fk(), request);
		if(StringUtils.isEmpty(fk.getId())){
			fk.setId(baseService.getUuid());
			baseService.insert(fk);
		}else{
			baseService.updateByPrimaryKey(fk);
		}
		sendJson(fk, response);
	}
	
	
	@RequestMapping("yjfkManage/fkDelete.html")
	public void fkDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		fk fk = new fk();
		fk.setId(id);
		baseService.deleteByPrimaryKey(fk);
	}*/
	
}
