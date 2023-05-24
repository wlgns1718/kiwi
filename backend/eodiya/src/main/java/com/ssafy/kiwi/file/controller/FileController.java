package com.ssafy.kiwi.file.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.kiwi.file.model.FileDto;
import com.ssafy.kiwi.file.service.FileService;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileController {
	
	private final Logger logger = LoggerFactory.getLogger(FileController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private FileService fileService;

	public FileController(FileService fileService) {
		super();
		this.fileService = fileService;
	}
	
	
	@GetMapping("boardimages/{boardno}")
	public ResponseEntity<?> getBoardImages(@PathVariable("boardno") int boardno)
			throws Exception {
		logger.info("getBoardImages - 호출 : " + boardno);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(boardno);
		try {
			List<FileDto> fileDtos = fileService.getBoardImages(boardno);
			resultMap.put("images",fileDtos);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("이미지 불러오기 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
	
	
	
	
}
