package model;

public class StuVO extends ProVO{
		private String scode;
		private String sname;
		private String sdept;
		private int year;
		private String birthday;
		private String advisor;  //교수번호 
		
		public String getScode() {
			return scode;
		}
		
		public void setScode(String scode) {
			this.scode = scode;
		}
		
		public String getSname() {
			return sname;
		}
		
		public void setSname(String sname) {
			this.sname = sname;
		}
		
		public String getSdept() {
			return sdept;
		}
		
		public void setSdept(String sdept) {
			this.sdept = sdept;
		}
		/**
		 * @return the year
		 */
		public int getYear() {
			return year;
		}
		/**
		 * @param year the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}
		/**
		 * @return the birthday
		 */
		public String getBirthday() {
			return birthday;
		}
		/**
		 * @param birthday the birthday to set
		 */
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		/**
		 * @return the advisor
		 */
		public String getAdvisor() {
			return advisor;
		}
		/**
		 * @param advisor the advisor to set
		 */
		public void setAdvisor(String advisor) {
			this.advisor = advisor;
		}
		@Override
		public String toString() {
			return "StuVO [scode=" + scode + ", sname=" + sname + ", sdept=" + sdept + ", year=" + year + ", birthday="
					+ birthday + ", advisor=" + advisor + ", getPname()=" + getPname() + "]";
		}
	
		
}
