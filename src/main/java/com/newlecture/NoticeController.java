package com.newlecture;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.dao.NoticeDao;
@Controller
@RequestMapping("/admin/notice/")
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	
//	@RequestMapping("list")
//	public String adff(Model model ) throws ClassNotFoundException, SQLException {
//		
//		model.addAttribute("list" ,noticeDao.getList());
//	System.out.println("shektm 요청이 있었습니다.");
//	return "/admin/notice/list";
//	}
	
	@RequestMapping("list")
	public String adff(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		int page = 1;
		String p = request.getParameter("p");
		
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		model.addAttribute("list" ,noticeDao.getList(page));
	System.out.println("shektm 요청이 있었습니다.");
	return "/admin/notice/list";
	}
}
