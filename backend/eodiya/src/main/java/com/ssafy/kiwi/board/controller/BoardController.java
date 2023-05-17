package com.ssafy.kiwi.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.kiwi.board.model.BoardDto;
import com.ssafy.kiwi.board.service.BoardService;
import com.ssafy.kiwi.tour.controller.TourController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(TourController.class);
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping
	public ResponseEntity<List<BoardDto>> listArticle() throws Exception {
		logger.info("listArticle - 호출");
		return new ResponseEntity<List<BoardDto>>(boardService.getList(), HttpStatus.OK);
	}
	
//	@GetMapping("/{articleno}")
//	public ResponseEntity<BoardDto> getArticle(@PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno) throws Exception {
//		logger.info("getArticle - 호출 : " + articleno);
//		boardService.updateHit(articleno);
//		return new ResponseEntity<BoardDto>(boardService.getArticle(articleno), HttpStatus.OK);
//	}
}
