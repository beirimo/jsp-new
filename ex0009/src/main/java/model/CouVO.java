package model;

public class CouVO extends ProVO{
		private String lcode;
		private String lname;
		private int hours;
		private String room;
		private String instructor;
		private int capacity;
		private int persons;
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
		 * @return the lname
		 */
		public String getLname() {
			return lname;
		}
		/**
		 * @param lname the lname to set
		 */
		public void setLname(String lname) {
			this.lname = lname;
		}
		/**
		 * @return the hours
		 */
		public int getHours() {
			return hours;
		}
		/**
		 * @param hours the hours to set
		 */
		public void setHours(int hours) {
			this.hours = hours;
		}
		/**
		 * @return the room
		 */
		public String getRoom() {
			return room;
		}
		/**
		 * @param room the room to set
		 */
		public void setRoom(String room) {
			this.room = room;
		}
		/**
		 * @return the instructor
		 */
		public String getInstructor() {
			return instructor;
		}
		/**
		 * @param instructor the instructor to set
		 */
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		/**
		 * @return the capacity
		 */
		public int getCapacity() {
			return capacity;
		}
		/**
		 * @param capacity the capacity to set
		 */
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		/**
		 * @return the persons
		 */
		public int getPersons() {
			return persons;
		}
		/**
		 * @param persons the persons to set
		 */
		public void setPersons(int persons) {
			this.persons = persons;
		}
		@Override
		public String toString() {
			return "CouVO [lcode=" + lcode + ", lname=" + lname + ", hours=" + hours + ", room=" + room
					+ ", instructor=" + instructor + ", capacity=" + capacity + ", persons=" + persons + ", getPname()="
					+ getPname() + "]";
		}
		
	
	
}
