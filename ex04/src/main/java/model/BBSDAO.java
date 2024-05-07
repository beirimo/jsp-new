package model;

import java.util.ArrayList;

public interface BBSDAO {
	

	
		//목록 불러오기
		public ArrayList<BBSVO> list();
		//한개 입력 -  글쓰기
		public void insert(BBSVO vo);
		//한개 읽기 - 게시글 하나 읽기
		public BBSVO read(int bid);
		//한개 수정 - 게시글 수정 
		public void update(BBSVO vo);
		//특정 게시물 하나 삭제 
		public void delete(int bid);
		
		public ArrayList<BBSVO> list(int page, int size);
		
		public int total();
		
		//데이터 총개수
		public int total(String query);
		
		
		
		//페이징 검색
		public ArrayList<BBSVO> list(int page, int size, String query);
			
		
	
		}

