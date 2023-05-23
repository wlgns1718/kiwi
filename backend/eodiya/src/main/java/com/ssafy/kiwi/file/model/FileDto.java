package com.ssafy.kiwi.file.model;

public class FileDto {
	private String uploadFilename;  // 작성자가 업로드한 파일명
    private String storeFilename; // 서버 내부에서 관리하는 파일명
    private String saveFolder;
    
    

	public FileDto(String uploadFilename, String storeFilename) {
		super();
		this.uploadFilename = uploadFilename;
		this.storeFilename = storeFilename;
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
    
}
