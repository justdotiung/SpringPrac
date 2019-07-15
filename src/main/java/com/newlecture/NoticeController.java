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
//	System.out.println("shektm ��û�� �־����ϴ�.");
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
	 * System.out.println("shektm ��û�� �־����ϴ�."); return "/admin/notice/list"; }
	 */

	@RequestMapping("list") // list?p=1
	public String adff(Model model, @RequestParam(name = "p", defaultValue = "1") Integer page)
			throws ClassNotFoundException, SQLException {
		// �⺻�ڷ����� null�� ������ ���ϱ� ������ �������� �Ķ���͸� ������ ž�� wrapper ������ ��������� ����� �Ѵ� (null ��
		// ���Ǵ°�)
		model.addAttribute("list", noticeDao.getList(page));
		System.out.println("shektm ��û�� �־����ϴ�.");
		return "/admin/notice/list";
	}

	/*
	 * ���Ź��
	 * 3.x�������
	 *  //get��û
	 * 
	 * @RequestMapping(value="reg" ,method=RequestMethod.GET) //list?p=1 public
	 * String adsdsdf() throws ClassNotFoundException, SQLException {
	 * 
	 * return "/admin/notice/reg";
	 *  } 
	 * //post��û
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.POST) //list?p=1 public
	 * String adsdsdf(String title) throws ClassNotFoundException, SQLException {
	 * //���𷺼� : list �������� return "redirect:list"; 
	 * }
	 */

	//4.x���
	// get��û
	@GetMapping("reg")
	public String adsdsdf() throws ClassNotFoundException, SQLException {
		System.out.println("get");
		return "/admin/notice/reg";
	}

	// post��û
	@PostMapping("reg")
	public String adsdsdf(String title) throws ClassNotFoundException, SQLException {
		// ���𷺼� : list ��������
		System.out.println("post");
		return "redirect:list";
	}
}
