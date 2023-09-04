package com.globalin.biz.dboard;

import java.util.Date;

public class D_BoardVO {

	
	private int rno;
	private int d_num;
	private String content;
	private String writer;
	private Date regdate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date redate) {
		this.regdate = redate;
	}
	public String toString() {
		return "D_BoardVO [ rno=" + rno +", d_num=" + d_num+", content=" + content +", writer="
				+ writer + ", regdate=" + regdate + "]";
	}
}
