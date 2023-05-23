package com.ssafy.kiwi.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface FileService {
	

	void insertFile(List<MultipartFile> files, int lastno) throws Exception;
	
}
