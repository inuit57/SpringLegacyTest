package com.itwillbs.domain;

import java.util.Date;

public class MemberVO {
	// tbl_member 테이블을 저장할 도메인 객체를 생성
	
	private String userid; 
	private String userpw ; 
	private String username ; 
	private String useremail; 
	private Date regdate ; 
	private Date updateDate ;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", regdate=" + regdate + ", updateDate=" + updateDate + "]";
	} 
	
}
