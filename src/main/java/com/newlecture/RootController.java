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
	//함수형태로 컨트롤러의 역할을 바꿔서 
	@RequestMapping("index")
	//return되는것을 그냥 출력해달라는 것
	@ResponseBody
	public String index() {
		//지금의 방식
		System.out.println("index 요청이 있었습니다.");
		return "welcomeHome";
	}
	
	
	@RequestMapping("index")
	@ResponseBody
	public void index(HttpServletResponse response) throws IOException {
		//과거의 방식
		PrintWriter out = response.getWriter();
		out.print("welcomeHome");
	}
	 */
	//@ResponseBody responce로 스프링이 인식해서 url 아닌 데이터 값으로 보여준다.
	@RequestMapping("index")
	public String index(Model model) {
	
		model.addAttribute("x", "웅이짱");
		return "index";
	}
	
	@RequestMapping("hello")
	@ResponseBody // 인코딩타입 설정해서  json 형태를 반환할때 많이 쓰게 된다
	public String adf() {
		return "환영합니다";
	}
	
}
