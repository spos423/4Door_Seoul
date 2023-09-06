package com.globalin.login.control;


public class ActionForward {//액션 처리 후에 어떤 뷰 페이지로 이동할지를 결정하기 위해 사용
	private String url;
	private boolean redirect;
	
	public ActionForward() {	}
	
	public ActionForward(String url) {this.url= url;	}
	
	public ActionForward(String url, boolean redirect) {//url=이동해야하는 페이지 
		this.url=url; this.redirect=redirect;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

}