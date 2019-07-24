package com.newlecture.web.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@GetMapping("login")
	public String error403() {
		return "member.login";
	}
	
	@PostMapping("logout")
	public String error404() {
		return "member.login";
	}
}
