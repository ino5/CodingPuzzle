package com.example.demo.Services.loginService;

import javax.servlet.http.HttpServletRequest;

public interface ServiceLogin {
	public int loginCheck(HttpServletRequest request);
	public int login(HttpServletRequest request);
}
