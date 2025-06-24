package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Controller 
public class GuestbookController {
	// 필드
	// 생성자
	// 메소드 gs
	// 메소드 일반
	// 방명록 리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		GuestbookDAO guestbookDAO= new GuestbookDAO();
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();

		// Model 개념
		// DispatcherServlet에게 명령
		// request의 Attribute영역에 "gList" 이름으로 guestbookList 넣어줘
		model.addAttribute("gList", guestbookList);
		
		// view 개념
		// DispatcherServlet에게 명령
		// "/WEB-INF/views/addlist.jsp"에 포워드 해
		return "addlist";
	}
	
	// 방명록 등록
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	// model DispatcherServlet에게 명령
	// request의 파라미터값을 꺼내서 GuestbookVO에 묶어줘
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookController.add()");
		
		GuestbookDAO guestbookDAO= new GuestbookDAO();
		guestbookDAO.guestbookInsert(guestbookVO);

		// view 리다이렉트(redirect:)
		// http://localhost:8888/guestbook4/list 리스트 제외 생략가능
		return "redirect:/list";
	}
	/*
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	// 1) 파라미터 값을 꺼내온다
	public String add(@RequestParam(value = "name") String name
					 ,@RequestParam(value = "password") String password
					 ,@RequestParam(value = "content") String content) {
		System.out.println("GuestbookController.add()");
	
	// 2) VO 메모리에 올린다.	
		GuestbookVO guestbookVO = new GuestbookVO(name, password, content);
		guestbookVO.setName		(aaa)
		guestbookVO.setPassword	(aaa)
		guestbookVO.setContent 	(aaa)
		

	// 3) DAO를 불러 데이터베이스에 값을 등록한다.
		GuestbookDAO guestbookDAO= new GuestbookDAO();
		guestbookDAO.guestbookInsert(guestbookVO);

		return "/WEB-INF/views/addlist.jsp";
	}
	*/
	
	// 삭제폼
	@RequestMapping(value = "/rform", method = {RequestMethod.GET, RequestMethod.POST})
	public String removeForm() {
		System.out.println("GuestbookController.removeForm()");
		
		return "removeform";
	}

	// 삭제
	@RequestMapping(value = "/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookController.remove()");
		
		GuestbookDAO guestbookDAO= new GuestbookDAO();
		guestbookDAO.guestbookDelete(guestbookVO);
		
		return "redirect:/list";
	}
}
