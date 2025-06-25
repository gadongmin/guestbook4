package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {
	// 필드
	@Autowired
	private GuestbookDAO guestbookDAO;
	// 생성자
	// 메소드 gs
	// 메소드 일반
	// -- 리스트
	public List<GuestbookVO> exeGetGuestbookList() {
		System.out.println("guestbookService.exeGetGuestbookList");
		
		//GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<GuestbookVO> guestbookList = guestbookDAO.guestbookSelect();
		
		return guestbookList;
	}

	// -- 등록
	public int exeGetGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("guestbookService.exeGetGuestbookAdd");
		
		//GuestbookDAO guestbookDAO= new GuestbookDAO();
		int count = guestbookDAO.guestbookInsert(guestbookVO);
		
		return count;
	}
	
	// -- 삭제
	public int exeGetGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("guestbookService.exeGetGuestbookRemove");
		
		//GuestbookDAO guestbookDAO= new GuestbookDAO();
		int count = guestbookDAO.guestbookDelete(guestbookVO);
		
		return count;
	}
}
