package com.ssafy.kiwi.file.model;

import java.io.File;

public class FileDto {
	private String uploadFilename;  // 작성자가 업로드한 파일명
    private String storeFilename; // 서버 내부에서 관리하는 파일명
    private String saveFolder;
    private int no;
    
    

	public FileDto(String uploadFilename, String storeFilename, int no, String saveFolder) {
		super();
		this.uploadFilename = uploadFilename;
		this.storeFilename = storeFilename;
		this.no = no;
		this.saveFolder = saveFolder;
	}
	public String getUploadFilename() {
		return uploadFilename;
	}
	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}
	public String getStoreFilename() {
		return storeFilename;
	}
	public void setStoreFilename(String storeFilename) {
		this.storeFilename = storeFilename;
	}
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "FileDto [uploadFilename=" + uploadFilename + ", storeFilename=" + storeFilename + ", saveFolder="
				+ saveFolder + ", no=" + no + "]";
	}
	
	
    
}
