package com.example.demo.Services.loginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service("ServiceLogin")
public class ServiceLoginImpl implements ServiceLogin {

	@Override
	public int loginSessionCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		System.out.println(user_id);
		return 0;
	}

	@Override
	public int login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");		
		session.setAttribute("user_id", user_id);
		session.setAttribute("password", password);
		System.out.println(session.getAttribute("user_id"));
		System.out.println(session.getAttribute("password"));
		
		return 0;
	}
	
}
