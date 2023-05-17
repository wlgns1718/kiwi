package com.ssafy.kiwi.board.service;

import java.util.List;

import com.ssafy.kiwi.board.model.BoardDto;

public interface BoardService {

	List<BoardDto> getList() throws Exception;

	void updateHit(int boardno) throws Exception;

	BoardDto getArticle(int boardno) throws Exception;
}
