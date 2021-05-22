package com.example.demo.Services.memberService;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.DAO.MainMapper;
import com.example.demo.DTO.MemberDTO;

@Service("ServiceMember")
public class ServiceMemberImpl implements ServiceMember {

	@Resource(name = "daoDB")
	private MainMapper mm;

	@Override
	public int show(Model model) {
		List<MemberDTO> testDto = mm.selectMember();
		System.out.println("Show the Member  : " + mm.selectMember());
		model.addAttribute("memberList", testDto);
		model.addAttribute("max_no", testDto.get(testDto.size()-1).getNo());
		return 0;
	}
	
	@Override
	public int submit(Model model) {
		MemberDTO dto = new MemberDTO();
		toDTOFromModel(dto, model);
		mm.insertMember(dto);
		return 0;
	}

	@Override
	public int delete(Model model) {
		MemberDTO dto = new MemberDTO();
		toDTOFromModel(dto, model);
		mm.deleteMember(dto);
		return 0;
	}

	@Override
	public int edit(Model model) {
		MemberDTO dto = new MemberDTO();
		toDTOFromModel(dto, model);
		mm.editMember(dto);
		return 0;
	}

	@Override
	public int toModelFromRequest(Model model, HttpServletRequest request) {
		model.addAttribute("no", request.getParameter("no"));
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("content", request.getParameter("content"));
		return 0;
	}

	@Override
	public int toDTOFromModel(MemberDTO dto, Model model) {
		dto.setNo(Integer.parseInt((String)model.getAttribute("no")));
		dto.setName((String)model.getAttribute("name"));
		dto.setContent((String)model.getAttribute("content"));
		return 0;
	}
	

}