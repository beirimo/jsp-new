package model;

import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		EnrollDAO  dao=new EnrollDAO ();
		//Connection con=Database.CON;   
//		StuDAOImpl dao=new StuDAOImpl();
		
//		vo.setPage(1);
//		vo.setSize(2);
//		vo.setKey("dept");
//		vo.setWord("건축");
//		dao.list(vo);
//		System.out.println("학번" + dao.getCode());
//		dao.read("96414404");
//		System.out.println(dao.getCode());
//		
//		boolean  result=dao.delete("96414405");
//		CouDAOImpl dao=new CouDAOImpl();
//		QueryVO vo=new QueryVO();
//		vo.setKey("lname");
//		vo.setWord("리");
//		vo.setPage(1);
//		vo.setSize(2);
//		dao.list(vo);
//		System.out.println("검색수" +  dao.total(vo));
//		dao.read("E221");
//		System.out.println("C301 삭제결과" + dao.delete("C301"));
//		System.out.println("C421 삭제결과" + dao.delete("C421"));
		dao.list("92414029");
	}

}
