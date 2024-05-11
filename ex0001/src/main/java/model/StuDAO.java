package model;

import java.util.*;

public interface StuDAO {
	//학생목록
	public ArrayList<StuVO> list(QueryVO vo);  //쿼리vo를 이용해 어레이리스트를 생성한다는건가 ?
	
	//학생목록
	
	public boolean delete(String code);
	
	//학생수정
	
	public void update(StuVO vo);
		
	
}
