package com.example.demo.Services.loginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service("ServiceLogin")
public class ServiceLoginImpl implements ServiceLogin {

	@Override
	public int loginCheck(HttpServletRequest request) {
		String sessionId = request.getRequestedSessionId();
		System.out.println(sessionId);
		return 0;
	}

	@Override
	public int login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		return 0;
	}
	
}
