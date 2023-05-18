package com.ssafy.kiwi.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.kiwi.board.model.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> getListWhenNoUserInfo() throws Exception;
	
	List<BoardDto> getListWhenUserInfoExistAndNotFollowSelect(int userno) throws Exception;
	
	List<BoardDto> getListWhenUserInfoExistAndFollowSelect(int userno) throws Exception;

	void updateHit() throws Exception;

	BoardDto getArticle(int boardno) throws Exception;

	boolean modifyArticle(BoardDto boardDto) throws Exception;

	boolean deleteArticle(int boardno) throws Exception;

	boolean writeArticle(BoardDto boardDto) throws Exception;
}
