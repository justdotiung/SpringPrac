package com.newlecture;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;

@Controller("adminNoticeController")
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

	/*
	 * @RequestMapping("list") public String adff(Model model,HttpServletRequest
	 * request) throws ClassNotFoundException, SQLException { int page = 1; String p
	 * = request.getParameter("p");
	 * 
	 * if(p != null && !p.equals("")) page = Integer.parseInt(p);
	 * 
	 * model.addAttribute("list" ,noticeDao.getList(page));
	 * System.out.println("shektm 요청이 있었습니다."); return "/admin/notice/list"; }
	 */

	@RequestMapping("list") // list?p=1
	public String adff(Model model, @RequestParam(name = "p", defaultValue = "1") Integer page)
			throws ClassNotFoundException, SQLException {
		// 기본자료형은 null을 가지지 못하기 때문에 앞으로의 파라매터를 받을때 탑을 wrapper 형으로 명시적으로 해줘야 한다 (null 이
		// 통용되는것)
		model.addAttribute("list", noticeDao.getList(page));
		System.out.println("shektm 요청이 있었습니다.");
		return "/admin/notice/list";
	}

	/*
	 * 과거방식
	 * 3.x번정방식
	 *  //get요청
	 * 
	 * @RequestMapping(value="reg" ,method=RequestMethod.GET) //list?p=1 public
	 * String adsdsdf() throws ClassNotFoundException, SQLException {
	 * 
	 * return "/admin/notice/reg";
	 *  } 
	 * //post요청
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.POST) //list?p=1 public
	 * String adsdsdf(String title) throws ClassNotFoundException, SQLException {
	 * //리디렉션 : list 페이지로 return "redirect:list"; 
	 * }
	 */

	//4.x방식
	// get요청
	@GetMapping("reg")
	public String adsdsdf() throws ClassNotFoundException, SQLException {
		System.out.println("get");
		return "/admin/notice/reg";
	}

	// post요청
	@PostMapping("reg")
	public String adsdsdf(String title) throws ClassNotFoundException, SQLException {
		// 리디렉션 : list 페이지로
		System.out.println("post");
		return "redirect:list";
	}
}
