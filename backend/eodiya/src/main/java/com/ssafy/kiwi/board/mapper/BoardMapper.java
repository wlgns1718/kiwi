package com.ssafy.kiwi.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.kiwi.board.model.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> getList() throws Exception;
}
