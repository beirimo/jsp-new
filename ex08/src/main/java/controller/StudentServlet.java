package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.*;

@WebServlet(value={"/stu/list", "/stu/list.json", "/stu/total", "/stu/insert","/stu/read","/stu/update"})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StuDAOImpl dao=new StuDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		RequestDispatcher dis=request.getRequestDispatcher("/home.jsp");
		
		switch(request.getServletPath()) {
		case "/stu/update":
			request.setAttribute("stu", dao.read(request.getParameter("scode")));
			request.setAttribute("pageName", "/stu/update.jsp");
			dis.forward(request, response);
			break;
		case "/stu/read":
			request.setAttribute("stu", dao.read(request.getParameter("scode")));
			request.setAttribute("pageName", "/stu/read.jsp");
			dis.forward(request, response);
			break;
		case "/stu/insert":
			request.setAttribute("code", dao.getCode());
			request.setAttribute("pageName", "/stu/insert.jsp");
			dis.forward(request, response);
		case "/stu/total": //테스트 /stu/total?key=dept&word=전산
			QueryVO vo1=new QueryVO();
			vo1.setKey(request.getParameter("key"));
			vo1.setWord(request.getParameter("word"));
			out.print(dao.total(vo1));
			break;
		case "/stu/list.json": //테스트 /stu/list.json?page=1&size=2&key=dept&word=전산
			QueryVO vo=new QueryVO();
			vo.setPage(Integer.parseInt(request.getParameter("page")));
			vo.setSize(Integer.parseInt(request.getParameter("size")));
			vo.setKey(request.getParameter("key"));
			vo.setWord(request.getParameter("word"));
			Gson gson=new Gson();
			out.print(gson.toJson(dao.list(vo)));
			break;
		case "/stu/list":
			request.setAttribute("pageName", "/stu/list.jsp");
			dis.forward(request, response);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("UTF-8");
		switch(request.getServletPath()) {
		
		case"/stu/insert":
			StuVO vo=new StuVO();
			vo.setScode(request.getParameter("scode"));
			vo.setSname(request.getParameter("sname"));
			vo.setSdept(request.getParameter("dept"));
			vo.setYear(Integer.parseInt(request.getParameter("year")));
			vo.setAdvisor(request.getParameter("advisor"));
			vo.setBirthday(request.getParameter("birthday"));
			dao.insert(vo);
			response.sendRedirect("/stu/list");	
			break;
			
		case "/stu/delete":
			String scode = request.getParameter("scode");
			out.print(dao.delete(scode));  // 딜리틓 ㅏ면 하면 딜리트 받아서 올거니까  ㅠ ㅠ 뭐라하셨찌 api는 딜리트 버튼 눌렀을 때 호출해줘야하니까 리드페이지로 가자~
			break;
			//삭제하려면 s코드를 받아야 함  프ㅜ론트에서 준거 받아올 때  겟 파라메터
			
			 //out 는 브라우저 객체   ,  
		case "/stu/update":
			vo=new StuVO();
			vo.setScode(request.getParameter("scode"));
			vo.setSname(request.getParameter("sname"));
			vo.setSdept(request.getParameter("dept"));
			vo.setYear(Integer.parseInt(request.getParameter("year")));
			vo.setAdvisor(request.getParameter("advisor"));
			vo.setBirthday(request.getParameter("birthday"));
			dao.update(vo);
			response.sendRedirect("/stu/read?scode=" + request.getParameter("scode")); 	  //"/stu/read?scode=" =>> scode를 알아야 리드를 할 수 있으니까??? 
			break;
		}
	}
	
	

}