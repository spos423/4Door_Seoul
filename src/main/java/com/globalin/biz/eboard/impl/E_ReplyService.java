package com.globalin.biz.eboard.impl;

import java.util.List;

import com.globalin.biz.eboard.E_ReplyVO;

public interface E_ReplyService {
	
	// 글 등록(Create)
	void insertReply(E_ReplyVO vo); // end insert

	// 글 수정(Update)
	void updateReply(E_ReplyVO vo); // end update

	// 글 삭제(Delete)
	void deleteReply(E_ReplyVO vo); // end delete

	// 글 상세 조회
	E_ReplyVO getReply(E_ReplyVO vo); // end getBoard

	// 글 목록 조회
	List<E_ReplyVO> getReplyList(E_ReplyVO vo); // end getBoardList
	
}
