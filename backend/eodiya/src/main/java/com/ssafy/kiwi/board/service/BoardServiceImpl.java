package com.ssafy.kiwi.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.kiwi.board.mapper.BoardMapper;
import com.ssafy.kiwi.board.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardDto> getList() throws Exception {
		return boardMapper.getList();
	}

	@Override
	public void updateHit(int boardno) throws Exception {
		boardMapper.updateHit();
	}

	@Override
	public BoardDto getArticle(int boardno) throws Exception {
		return boardMapper.getArticle(boardno);
	}
}
