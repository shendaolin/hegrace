package cn.hegrace.www.v1.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import cn.hegrace.www.v1.dto.XtSsglDto;
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
		map.put("ryid", xtJjryzzSeach.getRyid());
		flexigrid.setPages(xtJjryzzSeach.getPage());
		flexigrid.setTotal(baseService.queryForCount("XtJjryzz.select_xtjjryzz_count", map));
		flexigrid.setRows(baseService.queryForList("XtJjryzz.select_xtjjryzz_list", map));
		System.out.println("xx="+baseService.queryForList("XtJjryzz.select_xtjjryzz_list", map));
		sendJson(flexigrid, response);
	}

	@RequestMapping("xtjjryManage/xtJjryzzEdit.htm")
	public ModelAndView xtJjryzzEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("xtjjryManage/xtJjryzzEdit");
		String ryid = request.getParameter("ryid");
		HttpSession session = request.getSession();
		session.setAttribute("ryid1", ryid);
		System.out.println("ryidedit=" + ryid);
		XtJjry xtJjry = new XtJjry();
		xtJjry.setId(ryid);
		xtJjry = baseService.selectByPrimaryKey(xtJjry);
		mv.addObject("xtJjry", xtJjry);
		/*
		 * String id = request.getParameter("id"); XtGydmExample example = new
		 * XtGydmExample(); example.createCriteria().andLbidEqualTo(3);// 身份类型
		 * List<XtGydm> list = baseService.selectByExample(example);
		 * mv.addObject("XtDmbList", list); XtGydmExample example1 = new
		 * XtGydmExample(); example1.createCriteria().andLbidEqualTo(4);// 证件类型
		 * List<XtGydm> list1 = baseService.selectByExample(example1);
		 * mv.addObject("XtDmbList1", list1); System.out.println(list1); if
		 * (StringUtils.isNotEmpty(id)) { XtJjryzz xtJjryzz = new XtJjryzz();
		 * xtJjryzz.setId(id); xtJjryzz =
		 * baseService.selectByPrimaryKey(xtJjryzz); mv.addObject("xtJjryzz",
		 * xtJjryzz); }
		 */
		return mv;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("xtjjryManage/xtJjryzzSave.htm")
	public void xtJjryzzSave(HttpServletRequest request, HttpServletResponse response){
		XtJjryzz xtJjryzz=null;
		/*
		 * if (StringUtils.isEmpty(xtJjryzz.getId())) {
		 * xtJjryzz.setId(baseService.getUuid()); baseService.insert(xtJjryzz);
		 * } else { baseService.updateByPrimaryKey(xtJjryzz); }
		 */
		try {
			 try {
				xtJjryzz = (XtJjryzz) httpMessageConverter(new XtJjryzz(), request);
			} catch (Exception e) {
	

				e.printStackTrace();
			}
			upload(request,response);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		sendJson(xtJjryzz, response);
	}

	@RequestMapping("xtjjryManage/xtJjryzzDelete.htm")
	public void xtJjryzzDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		XtJjryzz xtJjryzz = new XtJjryzz();
		xtJjryzz.setTpdz(id);
		Map map = new HashMap();
		map.put("tpdz", id);
		List<XtSsglDto> xtSstj = baseService.selectList("XtJjryzz.delete_xtjjryzz_list", map);
		String savePath =  request.getRealPath("/");
		savePath = savePath + "/uploads/"+id;
		System.out.println(savePath);
		File f1 = new File(savePath);
		if (!StringUtils.isEmpty(id)) {
			f1.delete();
		}
	}

	public   void  upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath =  request.getRealPath("/");
		savePath = savePath + "/uploads/";
		System.out.println(savePath);
		File f1 = new File(savePath);
		// 这里接收了name的值
		System.out.println(request.getParameter("name"));
		if (!f1.exists()) {
			f1.mkdirs();
		}

		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}
		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String extName = "";
		String ryid="";
		HttpSession session = request.getSession();
		if(session.getAttribute("ryid1")!=null){
			ryid=(String) session.getAttribute("ryid1");
		}
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				name = item.getName();
				long size = item.getSize();
				String type = item.getContentType();
				System.out.println(size + " " + type);
				if (name == null || name.trim().equals("")) {
					continue;
				}

				// 扩展名格式：
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf("."));
				}

				File file = null;
				
				do {
					// 生成文件名：
					name = UUID.randomUUID().toString();
					file = new File(savePath + name + extName);
				} while (file.exists());

				File saveFile = new File(savePath + name + extName);
				try {
					item.write(saveFile);
					System.out.println(ryid);
					XtJjryzz xtJjryzz = new XtJjryzz();
					xtJjryzz.setRyid(ryid);
					xtJjryzz.setTpdz(name + extName);
					baseService.insert(xtJjryzz);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
