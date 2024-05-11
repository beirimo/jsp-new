package model;

import java.sql.*;

public class UserDAO {
		Connection con=Database.Con;
		
		public UserVO read(String uid) {
			UserVO vo = new UserVO();
			try { 
				String sql="select * from users where uid=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, uid);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					vo.setUid("uid");
					vo.setUname("uname");
					vo.setUpass("upass");
				}
				
			}catch (Exception e){
				System.out.println("read" + e.toString());
			}
			return vo;
		}
		
		

	}

