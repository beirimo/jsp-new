package model;

import java.util.*;

public interface StuDAO {
	//학생수정
	public void update(StuVO vo);
	
	//학생목록
	public ArrayList<StuVO> list(QueryVO vo);  //어떤 키로 어떤 단어를 검색할건지 알아야 검색하겠지
	
	//학생 삭제
	public boolean delete(String scode);
	//삭제할 때는 프라이머리키로 삭제하는 거야
	
		 
		 //검색 수       몇개 했는지 알아야 페이징을 할 수 있으니까
		 public int total(QueryVO vo);   // return타입은 내가 받고싶은게 뭔지에 따라 정하는거
		 
		 //새로운 학번 구하기
		 public String getCode();
		 
		 //학생등록
		 public void insert(StuVO vo);
		 
		 
		 //학생정보
		 public StuVO  read(String scode);
		 
		 
		 
}
