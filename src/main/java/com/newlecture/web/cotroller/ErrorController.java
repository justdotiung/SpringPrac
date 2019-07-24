package com.newlecture.web.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/")
public class ErrorController {

	
	@GetMapping("403")
	public String error403() {
		return "error/403";
	}
	//Ưȭ�ȳ༮�� ���ʿ� �־��Ѵ�
	/*
	@GetMapping("{num}")
	public String error() {
		return "error/default";
	}
	*/
}
