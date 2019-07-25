package com.newlecture.web.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("login")
	public String error403() {
		return "member.login";
	}
	
	@PostMapping("logout")
	public String error404() {
		return "member.login";
	}
	@GetMapping("join")
	public String join() {
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(Member member) {
		String pwd = member.getPw();
		System.out.println(pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		member.setPw(pwd);

		memberDao.insert(member);
		
		
		return "redirect:../index";
	}
}
