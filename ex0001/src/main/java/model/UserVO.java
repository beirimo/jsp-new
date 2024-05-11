package model;

import java.util.Date;

public class UserVO {
	
	private String uid;
	private String upass;
	private String uname;
	private String phone;
	private String add1;
	private String add2;
	private String photo;
	private Date jdate;
	private Date udate;
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the upass
	 */
	public String getUpass() {
		return upass;
	}
	/**
	 * @param upass the upass to set
	 */
	public void setUpass(String upass) {
		this.upass = upass;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the add1
	 */
	public String getAdd1() {
		return add1;
	}
	/**
	 * @param add1 the add1 to set
	 */
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	/**
	 * @return the add2
	 */
	public String getAdd2() {
		return add2;
	}
	/**
	 * @param add2 the add2 to set
	 */
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the jdate
	 */
	public Date getJdate() {
		return jdate;
	}
	/**
	 * @param jdate the jdate to set
	 */
	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	/**
	 * @return the udate
	 */
	public Date getUdate() {
		return udate;
	}
	/**
	 * @param udate the udate to set
	 */
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upass=" + upass + ", uname=" + uname + ", phone=" + phone + ", add1=" + add1
				+ ", add2=" + add2 + ", photo=" + photo + ", jdate=" + jdate + ", udate=" + udate + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
