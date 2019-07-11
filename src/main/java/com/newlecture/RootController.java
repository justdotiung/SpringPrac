package com.newlecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	//함수형태로 컨트롤러의 역할을 바꿔서 
	@RequestMapping("/index")
	public void aa() {
		System.out.println("index 요청이 있었습니다.");
	}
	
	@RequestMapping("/hello")
	public void adf() {
		System.out.println("hello 요청이 있었습니다.");
	}
}
