package model;

public class EnrollVO extends CouVO{
	private String scode;
	private int grade;
	private String edate;
	/**
	 * @return the scode
	 */
	public String getScode() {
		return scode;
	}
	/**
	 * @param scode the scode to set
	 */
	public void setScode(String scode) {
		this.scode = scode;
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
	@Override
	public String toString() {
		return "EnrollVO [scode=" + scode + ", grade=" + grade + ", edate=" + edate + ", getLcode()=" + getLcode()
				+ ", getLname()=" + getLname() + ", getHours()=" + getHours() + ", getRoom()=" + getRoom()
				+ ", getInstructor()=" + getInstructor() + ", getCapacity()=" + getCapacity() + ", getPersons()="
				+ getPersons() + ", toString()=" + super.toString() + ", getPcode()=" + getPcode() + ", getPname()="
				+ getPname() + ", getDept()=" + getDept() + ", getHiredate()=" + getHiredate() + ", getTitle()="
				+ getTitle() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	
}
