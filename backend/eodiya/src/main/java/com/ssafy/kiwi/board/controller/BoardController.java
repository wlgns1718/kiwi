package com.ssafy.kiwi.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.kiwi.board.model.BoardDto;
import com.ssafy.kiwi.board.service.BoardService;
import com.ssafy.kiwi.tour.controller.TourController;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(TourController.class);
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		logger.debug("board list call parameter");
//		List<BoardDto> list = boardService.getList();
//		model.addAttribute("articles", list);
		return "board/list";
	}
}
