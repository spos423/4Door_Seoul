package com.globalin.biz.frboard;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FR_BoardVO {

	private int num; //번호
	private String title;//제목
	private String content;//내용
	private String writer;//자성자
	private Date writeday; //작성일
	private int readcount; //조회수  
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
	
	public int getNum() {
		return num;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteday() {
		return writeday;
	}
	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String toString() {
		return "FR_BoardVO [num=" + num + ", title=" + title + ", content=" + content +", writer="
				+ writer + ", writeday=" + writeday + ", readcount="+ readcount + "]";
	}
	
	
	
}
