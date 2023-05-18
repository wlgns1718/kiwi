package com.ssafy.kiwi.board.service;

import java.util.List;

import com.ssafy.kiwi.board.model.BoardDto;
import com.ssafy.kiwi.board.model.BoardViewDto;

public interface BoardService {

	List<BoardDto> getList(BoardViewDto boardviewDto) throws Exception;

	void updateHit(int boardno) throws Exception;

	BoardDto getArticle(int boardno) throws Exception;

	boolean modifyArticle(BoardDto boardDto) throws Exception;

	boolean deleteArticle(int boardno) throws Exception;

	boolean writeArticle(BoardDto boardDto) throws Exception;
}
