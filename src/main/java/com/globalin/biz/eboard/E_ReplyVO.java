package com.globalin.biz.eboard;

import java.sql.Timestamp;

public class E_ReplyVO {
	
	private int num;
	private int step;
	private int depth;
	private String content;
	private int ref;
	private char deleteyn;
	private String writer;
	private Timestamp writedate;
	private Timestamp updatedate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public char getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(char deleteyn) {
		this.deleteyn = deleteyn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
}
