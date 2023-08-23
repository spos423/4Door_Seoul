package com.globalin.biz.eboard.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.eboard.E_ReplyVO;

@Service
public class E_ReplyServiceImpl implements E_ReplyService {
	
	@Autowired
	private E_ReplyDAO e_replyDAO;
	
	@Override
	public void insertReply(E_ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReply(E_ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(E_ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E_ReplyVO getReply(E_ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E_ReplyVO> getReplyList(E_ReplyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
