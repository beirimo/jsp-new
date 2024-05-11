package model;

public class GradeVO extends StuVO{
	private String lcode;
	private String edate;
	private int grade;
	/**
	 * @return the lcode
	 */
	public String getLcode() {
		return lcode;
	}
	/**
	 * @param lcode the lcode to set
	 */
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	/**
	 * @return the edate
	 */
	public String getEdate() {
		return edate;
	}
	/**
	 * @param edate the edate to set
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "GradeVO [lcode=" + lcode + ", edate=" + edate + ", grade=" + grade + ", getScode()=" + getScode()
				+ ", getSname()=" + getSname() + ", getSdept()=" + getSdept() + ", getYear()=" + getYear() + "]";
	}
	
	
	
}


	
	
	

