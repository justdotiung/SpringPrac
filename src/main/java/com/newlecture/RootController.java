package com.newlecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	//�Լ����·� ��Ʈ�ѷ��� ������ �ٲ㼭 
	@RequestMapping("/index")
	public void aa() {
		System.out.println("index ��û�� �־����ϴ�.");
	}
	
	@RequestMapping("/hello")
	public void adf() {
		System.out.println("hello ��û�� �־����ϴ�.");
	}
}
