package model;

import java.sql.*;

public class TestDB {

	public static void main(String[] args) {
		//Connection con=Database.CON;   
		StuDAOImpl dao=new StuDAOImpl();
		QueryVO vo=new QueryVO();
//		vo.setPage(1);
//		vo.setSize(2);
//		vo.setKey("dept");
//		vo.setWord("건축");
//		dao.list(vo);
//		System.out.println("학번" + dao.getCode());
//		dao.read("96414404");
		System.out.println(dao.getCode());
	}

}
