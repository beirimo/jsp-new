package model;
import java.sql.*;


public class Database {
	public static Connection Con;
	static {
		try {
			
			 Class.forName("com.mysql.jdbc.Driver"); 
			 Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "jsp", "pass"); 
			 System.out.println("접속성공"); 
			//이부분 이거  외워서 써야하나? 아니면 뭐 선택해서 Source처럼 불러오는건가????
			
		}catch(Exception e) {
			System.out.println("접속실패 " + e.toString());
		}
	}
	
	

}
