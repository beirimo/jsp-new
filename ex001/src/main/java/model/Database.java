package model;
import java.sql.*;

public class Database {
	public static Connection CON; 
	static {
		try {
			 Class.forName("com.mysql.jdbc.Driver"); 
			 CON=DriverManager.getConnection("jdbc:mysql://localhost:3306/haksadb", "haksa", "pass");  //webdb가 아니고 jspdb로 해야지 
			 System.out.println("접속성공"); 
		}catch(Exception e) { 
			 System.out.println("접속실패:" + e.toString()); 
		}
	}
}