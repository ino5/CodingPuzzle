package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.MemberDTO;
import com.example.demo.Services.loginService.ServiceLogin;
import com.example.demo.Services.loginService.ServiceLoginImpl;
import com.example.demo.Services.memberService.ServiceMemberImpl;

@Controller
public class MainController {
	
	@Resource(name = "ServiceLogin")
	private ServiceLoginImpl svcLoginCheck;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) throws Exception {
		svcLoginCheck.loginCheck(request);
		return "thymeleaf/index";
	}
	
	
	
	
	@Resource(name = "ServiceMember")
	private ServiceMemberImpl svcMember;

	@RequestMapping(value = "/member")
	public String main(Model model) {
		svcMember.show(model);
		return "thymeleaf/member-list";
	}

	@PostMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		svcMember.toModelFromRequest(model, request);
		svcMember.submit(model);
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		svcMember.toModelFromRequest(model, request);
		svcMember.delete(model);
		return "redirect:/";
	}

	@PostMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		svcMember.toModelFromRequest(model, request);
		svcMember.edit(model);
		return "redirect:/";
	}

	@RequestMapping("/welcome-thymeleaf")
	public String welcome(Model model) throws Exception {
		model.addAttribute("greeting", "Hello Thymeleaf!");
		return "thymeleaf/welcome";
	}

	@RequestMapping("/ajax-index")
	public String ajaxIndex(Model model) throws Exception {
		return "thymeleaf/ajax-index";
	}

	@RequestMapping("/ajax-request")
	public @ResponseBody Map<String, Object> ajaxRequest(Model model) throws Exception {
		Map<String, Object> mv = new HashMap<>();
		mv.put("hi", "hoho");
		return mv;
	}

	@PostMapping("/ajax-send")
	public @ResponseBody String ajaxSend(@RequestBody String payload) {
		System.out.println("/ajax-send");
		String myAnswer = "";
		if(payload.equals("hi")) {
			myAnswer = "hello";
		} else if(payload.equals("bye")) {
			myAnswer = "see you later";
		} else {
			myAnswer = "what?";
		}
		System.out.println(payload);
		return myAnswer;
	}
}