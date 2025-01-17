package model;

import java.util.ArrayList;
import java.sql.*;

public class CommentDAOImpl2 implements CommentDAO{
	Connection con=Database.CON;
	
	@Override
	public ArrayList<CommentVO> list(int bid, int page, int size) {
		ArrayList<CommentVO> array=new ArrayList<CommentVO>();
		try {
			String sql="select * from view_comments";
			sql+= " where bid=?";
			sql+= " order by cid desc";
			sql+= " limit ?, ? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2,  (page-1)*size);
			ps.setInt(3,  size);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CommentVO vo=new CommentVO();
				vo.setCid(rs.getInt("cid"));
				vo.setBid(rs.getInt("bid"));
				vo.setCdate(rs.getString("cdate"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setUname(rs.getString("uname"));
				vo.setPhoto(rs.getString("photo"));
				array.add(vo);
				System.out.println(vo.toString());									
			}
		}catch(Exception e) {
		System.out.println("목록: " +  e.toString());
		
	}
		return array;
	}

	@Override
	public void insert(CommentVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CommentVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int total(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}
}