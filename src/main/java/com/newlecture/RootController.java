package com.newlecture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.dao.NoticeDao;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private NoticeDao noticeDao;
	
	/*
	//�Լ����·� ��Ʈ�ѷ��� ������ �ٲ㼭 
	@RequestMapping("index")
	//return�Ǵ°��� �׳� ����ش޶�� ��
	@ResponseBody
	public String index() {
		//������ ���
		System.out.println("index ��û�� �־����ϴ�.");
		return "welcomeHome";
	}
	
	
	@RequestMapping("index")
	@ResponseBody
	public void index(HttpServletResponse response) throws IOException {
		//������ ���
		PrintWriter out = response.getWriter();
		out.print("welcomeHome");
	}
	 */
	//@ResponseBody responce�� �������� �ν��ؼ� url �ƴ� ������ ������ �����ش�.
	@RequestMapping("index")
	public String index(Model model) {
	
		model.addAttribute("x", "����¯");
		return "index";
	}
	
	@RequestMapping("hello")
	@ResponseBody // ���ڵ�Ÿ�� �����ؼ�  json ���¸� ��ȯ�Ҷ� ���� ���� �ȴ�
	public String adf() {
		return "ȯ���մϴ�";
	}
	
}
