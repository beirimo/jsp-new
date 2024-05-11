package model;
import java.util.*;

public interface CouDAO {
	//강좌수정
	public void update(CouVO vo);
	
	
	//강좌삭제 
	public boolean delete(String lcode);
	
	
	//강좌 정보
	 public CouVO read(String lcode); // 리드하ㅐ면 VO가 리턴이 됨
	
	 //강좌등록
	   public void insert(CouVO vo);
	//새로운 강좌코드
	public String getCode();
	
	
	//강좌목록
	public ArrayList<CouVO> list(QueryVO vo);  //검색하고 뭐 하려면 쿼리vo가 ㅍ ㅣㄹ요해서 넣어줌
	
	//rjatortno 
	public int total(QueryVO vo);
		
	
  	

}
