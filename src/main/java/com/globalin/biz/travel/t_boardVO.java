package com.globalin.biz.travel;

import java.sql.Date;
import java.sql.Timestamp;

public class t_boardVO {

	private int num;
	private int ct_u;
	private int ct_d;
	private String title;
	private String content;
	private String zipcode;
	private String address;
	private String traffic;
	private String price;
	private Timestamp time_s;
	private Timestamp time_e;
	private String open_day;
	private String tel;
	private String uri;
	private String bestmenu;
	private String delete_yn;
	private Date delete_day;
	private String writer;
	private Date write_day;
	private String updater;
	private Date update_day;
	private String filepath;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCt_u() {
		return ct_u;
	}
	public void setCt_u(int ct_u) {
		this.ct_u = ct_u;
	}
	public int getCt_d() {
		return ct_d;
	}
	public void setCt_d(int ct_d) {
		this.ct_d = ct_d;
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
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Timestamp getTime_s() {
		return time_s;
	}
	public void setTime_s(Timestamp time_s) {
		this.time_s = time_s;
	}
	public Timestamp getTime_e() {
		return time_e;
	}
	public void setTime_e(Timestamp time_e) {
		this.time_e = time_e;
	}
	public String getOpen_day() {
		return open_day;
	}
	public void setOpen_day(String open_day) {
		this.open_day = open_day;
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
	public String getBestmenu() {
		return bestmenu;
	}
	public void setBestmenu(String bestmenu) {
		this.bestmenu = bestmenu;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public Date getDelete_day() {
		return delete_day;
	}
	public void setDelete_day(Date delete_day) {
		this.delete_day = delete_day;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_day() {
		return write_day;
	}
	public void setWrite_day(Date write_day) {
		this.write_day = write_day;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdate_day() {
		return update_day;
	}
	public void setUpdate_day(Date update_day) {
		this.update_day = update_day;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	

}
