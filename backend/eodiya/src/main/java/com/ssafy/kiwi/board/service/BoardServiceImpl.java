package com.ssafy.kiwi.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.kiwi.board.mapper.BoardMapper;
import com.ssafy.kiwi.board.model.BoardDto;
import com.ssafy.kiwi.board.model.BoardViewDto;
import com.ssafy.kiwi.board.model.LikesDto;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardDto> getList(BoardViewDto boardviewDto) throws Exception {
		if (boardviewDto.getUserno() == 0) {
			List<BoardDto> list = boardMapper.getListWhenNoUserInfo();
			System.out.println(1);
			return list;

		} else if (boardviewDto.getIsFollowSelect() == 0) {
			System.out.println(2);
			return boardMapper.getListWhenUserInfoExistAndNotFollowSelect(boardviewDto.getUserno());
		} else {
			System.out.println(3);
			return boardMapper.getListWhenUserInfoExistAndFollowSelect(boardviewDto.getUserno());
		}

	}

	@Override
	public void updateHit(int boardno) throws Exception {
		boardMapper.updateHit();
	}

	@Override
	public BoardDto getArticle(int boardno) throws Exception {
		return boardMapper.getArticle(boardno);
	}

	@Override
	public boolean modifyArticle(BoardDto boardDto) throws Exception {
		return boardMapper.modifyArticle(boardDto);
	}

	@Override
	public boolean deleteArticle(int boardno) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.deleteArticle(boardno);
	}

	@Override
	public boolean writeArticle(BoardDto boardDto) throws Exception {
		return boardMapper.writeArticle(boardDto);
	}

	@Override
	public boolean addLikes(LikesDto likesDto) throws Exception {
		return boardMapper.addLikes(likesDto);
	}

	@Override
	public boolean deleteLikes(LikesDto likesDto) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.deleteLikes(likesDto);
	}

	@Override
	public List<BoardDto> getBoardListwithUserInfo(int userno) throws Exception {
		System.out.println(userno);
		return boardMapper.getBoardListwithUserInfo(userno);
	}
}
