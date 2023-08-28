package com.globalin.biz.eboard;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class E_BoardVO {
	private int num;
	private String title;
	private String content;
	private String zipcode;
	private String address;
	private String traf;
	private String price;
	private String startdate;
	private String enddate;
	private String tel;
	private String uri;
	private char deleteyn;
	private String writer;
	private Timestamp writedate;
	private String updater;
	private Timestamp updatedate;
	private int readcnt;
	private MultipartFile thumb_img1;
	private String img1_url;
	public int getNum() {
		return num;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTraf() {
		return traf;
	}
	public void setTraf(String traf) {
		this.traf = traf;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
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
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public MultipartFile getThumb_img1() {
		return thumb_img1;
	}
	public void setThumb_img1(MultipartFile thumb_img1) {
		this.thumb_img1 = thumb_img1;
	}
	public String getImg1_url() {
		return img1_url;
	}
	public void setImg1_url(String img1_url) {
		this.img1_url = img1_url;
	}
	
}
