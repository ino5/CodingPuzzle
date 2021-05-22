package com.example.demo.Services.memberService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.demo.DTO.MemberDTO;

public interface ServiceMember {
	public int show(Model model);
	public int submit(Model model);
	public int delete(Model model);
	public int edit(Model model);
	public int toModelFromRequest(Model model, HttpServletRequest request);
	public int toDTOFromModel(MemberDTO dto, Model model);
}