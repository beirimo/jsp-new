package model;
import java.util.*;

public interface CouDAO {
	
	   //강좌등록
	   public void insert(CouVO vo);
	//새로운 강좌코드
	public String getCode();
	
	
	//강좌목록
	public ArrayList<CouVO> list(QueryVO vo);  //검색하고 뭐 하려면 쿼리vo가 ㅍ ㅣㄹ요해서 넣어줌
	
	//rjatortno 
	public int total(QueryVO vo);
		
	
  	

}
