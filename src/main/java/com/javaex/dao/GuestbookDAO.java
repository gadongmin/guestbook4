package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookDAO {
	
	// 필드
	@Autowired
	private SqlSession sqlSession;
	
	// 생성자
	
	// 메소드 gs
	
	// 메소드 일반
	public List<GuestbookVO> guestbookSelect() {
		System.out.println("GuestDAO.guestbookSelect()");

		// SqlSession sqlSession = new SqlSession(); - 삭제
		List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");

		return guestbookList;
	}

	public int guestbookInsert(GuestbookVO guestbookVO) {
		System.out.println("GuestDAO.guestbookInsert()");

		// SqlSession sqlSession = new SqlSession(); - 삭제
		int count = sqlSession.insert("guestbook.insert", guestbookVO);

		return count;
	}

	public int guestbookDelete(GuestbookVO guestbookVO) {
		System.out.println("GuestDAO.guestbookDelete()");

		// SqlSession sqlSession = new SqlSession(); - 삭제
		int count = sqlSession.delete("guestbook.delete", guestbookVO);

		return count;
	}
}
