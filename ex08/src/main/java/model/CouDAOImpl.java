package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;

public class CouDAOImpl implements CouDAO{
	Connection con=Database.CON;

	@Override
	public ArrayList<CouVO> list(QueryVO vo) {
		ArrayList<CouVO> array=new ArrayList<CouVO>();
		try {
			String sql="select * from view_cou";
			sql +=" where " + vo.getKey() +" like ?";   //lname 등은  key?니까 변수로 받을 수없어서?
			sql +=" limit ?, ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "%" +  vo.getWord()+ "%");
			ps.setInt(2, ((vo.getPage()-1) * vo.getSize()));
			ps.setInt(3, vo.getSize());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CouVO cou=new CouVO();
				cou.setLcode(rs.getString("lcode"));
				cou.setLname(rs.getString("lname"));
				cou.setHours(rs.getInt("hours"));
				cou.setRoom(rs.getString("room"));
				cou.setInstructor(rs.getString("instructor"));
				cou.setPersons(rs.getInt("persons"));
				cou.setPname(rs.getString("pname"));
				cou.setCapacity(rs.getInt("capacity"));
				System.out.println(cou.toString());
				array.add(cou);
			}
			
		}catch (Exception e) {
			System.out.println("강좌목록 " + e.toString());
		}
		
		return array;
	}

	   @Override
	   public int total(QueryVO vo) {
	      int result=0;
	      try {
	         String sql = "select count(*) from view_cou";
	         sql+= " where " + vo.getKey() + " like ?";
	         PreparedStatement ps = con.prepareStatement(sql);
	         ps.setString(1, "%" + vo.getWord() + "%");
	         ResultSet rs = ps.executeQuery();
	         while(rs.next()) {
	            result=rs.getInt("count(*)");
	         }
	      }catch(Exception e) {
	         System.out.println("검색결과개수" + e.toString());
	      }
	      
	      return result;
	   }

	@Override
	public String getCode() {
		String code="";
		try {
	         String sql = "select concat('N', substring(max(lcode),2)+1) code from courses";	        
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();
	         while(rs.next()) {
	           code=rs.getString("code");
	         }
	      }catch(Exception e) {
	         System.out.println("강좌코드:" + e.toString());
	      }
		return code;
	}

	
		   @Override
		   public void insert(CouVO vo) {
			   
		      try {
		         String sql="insert into courses(lcode,lname,hours,room,instructor,capacity,persons)";
		         sql += " values(?,?,?,?,?,?,0)";
		        
		         PreparedStatement ps=con.prepareStatement(sql);
		         ps.setString(1, vo.getLcode());
		         ps.setString(2, vo.getLname());
		         ps.setInt(3, vo.getHours());
		         ps.setString(4, vo.getRoom());
		         ps.setString(5, vo.getInstructor());
		         ps.setInt(6, vo.getCapacity());
		         ps.execute();
		      }catch(Exception e) {
		         System.out.println("강좌등록:" + e.toString());
		    

		         
		         

		         
		      }
		   }

		@Override
		public CouVO read(String lcode) {
			CouVO cou=new CouVO();
			try {
				String sql="select * from view_cou";
				sql +=" where lcode=?";   // 앞에 꼭 띄어쓰기하고 
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, lcode);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					 cou=new CouVO();
					cou.setLcode(rs.getString("lcode"));
					cou.setLname(rs.getString("lname"));
					cou.setHours(rs.getInt("hours"));
					cou.setRoom(rs.getString("room"));
					cou.setInstructor(rs.getString("instructor"));
					cou.setPersons(rs.getInt("persons"));
					cou.setPname(rs.getString("pname"));
					cou.setCapacity(rs.getInt("capacity"));
					System.out.println(cou.toString());
					
				}
				
			}catch (Exception e) {
				System.out.println("강좌정보 " + e.toString());
			}
			return cou;
		}
  //list랑 비슷해서 리스트에서 트라이캐치 복사한거임  왜비슷한걸까???

		@Override
		public boolean delete(String lcode) {
			try {
		         String sql="delete from courses where lcode=?)";			   
		         PreparedStatement ps=con.prepareStatement(sql);
		         ps.setString(1, lcode);		         
		         ps.execute();
		         return true;
		      }catch(Exception e) {
		         System.out.println("강좌등록:" + e.toString());
		         return false;
		}
}

		@Override
		public void update(CouVO vo) {
			  try {
			         String sql="update courses set lname=?,hours=?,room=?,instructor=?,capacity=?";
			         sql += " where lcode=?";			
			         PreparedStatement ps=con.prepareStatement(sql);
			         ps.setString(6, vo.getLcode());
			         ps.setString(1, vo.getLname());
			         ps.setInt(2 , vo.getHours());
			         ps.setString(3, vo.getRoom());
			         ps.setString(4, vo.getInstructor());
			         ps.setInt(5, vo.getCapacity());
			         ps.execute();
			      }catch(Exception e) {
			         System.out.println("강좌수정:" + e.toString());			    
			         			        			         			      
			      }
			
		}
}