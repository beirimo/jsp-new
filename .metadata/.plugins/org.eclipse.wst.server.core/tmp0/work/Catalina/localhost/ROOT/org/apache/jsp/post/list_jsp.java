/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.88
 * Generated at: 2024-05-01 06:32:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"divPosts\"></div> <!-- 밑에 스크립드들은 데이터출력을 위한 도구일뿐 결국 데이터는 여기에 들어오는것. -->\r\n");
      out.write("\r\n");
      out.write("<script id=\"tempPosts\" type=\"x-handlebars-template\">\r\n");
      out.write("    <table class=\"table table-bordered table-dark\" style =\"text-align: center;\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>번호</td><td>제목</td><td>작성자</td><td>작성일</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        {{#each documents}}\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>{{pid}}</td>\r\n");
      out.write("                <td><a href=\"/posts/read?pid={{pid}}\" style = \"text-decoration : none; color: white;\">{{title}}</td></a>  <!-- 데이터가 넘어가는 링크를 걸어준다. -->\r\n");
      out.write("                <td>{{writer}}</td>\r\n");
      out.write("                <td>{{fdate}}</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        {{/each}}\r\n");
      out.write("    </table>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class = \"row\">\r\n");
      out.write("    <div class = \"col-4 col-md-4 mt-3\"><!-- 중간이상 해상도일대는 4칸-->\r\n");
      out.write("        <form action=\"\" name=\"frm\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("            <input type=\"text\"class=\"form-control\" placeholder=\"검색어를 입력하세요\" name=\"query\">\r\n");
      out.write("            <button class=\"btn btn-primary\">검색</button>\r\n");
      out.write("            <span id=\"su\" class=\"ps-3 pt-3\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col text-end mt-3\" id=\"divWrite\" style=\"display:none;\"> <!-- 아무튼 div안에 넣어야 만지기가 편하다. -->\r\n");
      out.write("        <a href=\"/posts/insert\"><button class=\"btn btn-secondary\">글쓰기 </button></a> <!--누르면 a태그의 지정된 곳으로 가자 -->\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"text-center my-4\"> <!-- my는 마진 y축이라는 뜻-->\r\n");
      out.write("    <button class=\"btn btn-primary\" id=\"prev\">이전</button>\r\n");
      out.write("    <span class=\"mx-2\" id=\"page\"><b>1</b></span> <!-- 같은줄에 하기위해 div아니고 span으로 한거임. -->\r\n");
      out.write("    <button class=\"btn btn-danger\" id=\"next\">다음</button>\r\n");
      out.write("</div>\r\n");
      out.write("<script> //ajax은 스크립트에서 쓴다.\r\n");
      out.write("    let page = 1; //시작페이지설정해주기 \r\n");
      out.write("    const size =15;\r\n");
      out.write("    let query=\"\";\r\n");
      out.write("    dataGet();\r\n");
      out.write("    function dataGet() { //함수로 쓴이유는 여러번 해야하기때문에 \r\n");
      out.write("        $.ajax({ //데이터 호출시 ajax을 함수로 쓴다. \r\n");
      out.write("            type: \"get\",\r\n");
      out.write("            url: \"/post/list.json\", // 로컬서버는 ~3000까지는 생략가능 \r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            data: {page, size, query}, //page를 데이타로 넘겨주기 \r\n");
      out.write("            success: function (data) { //url의 데이터가 여기로 들어감 \r\n");
      out.write("                // alert(\"성공~\");\r\n");
      out.write("                console.log(data);\r\n");
      out.write("                const temp = Handlebars.compile($(\"#tempPosts\").html()); //아이디가 tempPosts인걸 html로 compile해서 temp에 저장 \r\n");
      out.write("                $(\"#divPosts\").html(temp(data)); // temp에 data를 넣고  divPosts에 출력   \r\n");
      out.write("                $(\"#su\").html(`<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.su}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<b>건이 검색되었습니다.`);\r\n");
      out.write("                const last = Math.ceil(data.su/size); //last를 정의해주기(페이지/마지막페이지를 할려고)\r\n");
      out.write("                $(\"#page\").html(page + \"/\" + last); //데이터 불러오기 성공을 하면 #page를 출력해라  이거없으면 번호가 가감이 안된다. \r\n");
      out.write("                if(page == 1){ //1페이지일대 이전버튼안눌리게하기\r\n");
      out.write("                    $(\"#prev\").attr(\"disabled\", true)\r\n");
      out.write("                }else{\r\n");
      out.write("                    $(\"#prev\").attr(\"disabled\", false)\r\n");
      out.write("                }\r\n");
      out.write("                if(page == last){ //마지막페이지가 다음안눌리게하기\r\n");
      out.write("                    $(\"#next\").attr(\"disabled\", true)\r\n");
      out.write("                }else{\r\n");
      out.write("                    $(\"#next\").attr(\"disabled\", false)\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    };\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    \r\n");
      out.write("    //다음버튼 클릭\r\n");
      out.write("    $(\"#next\").on(\"click\", function () {//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자\r\n");
      out.write("        page++;\r\n");
      out.write("        dataGet();\r\n");
      out.write("    });\r\n");
      out.write("    $(\"#prev\").on(\"click\", function () {//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자\r\n");
      out.write("        page--;\r\n");
      out.write("        dataGet();\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    //검색창 submit안되게 하기\r\n");
      out.write("    $(frm).on(\"submit\", function(e){ //frm 이 submit이벤트를  function(e)에 넣어줌. \r\n");
      out.write("        e.preventDefault(); //e를 막아라.\r\n");
      out.write("        query=$(frm.query).val();\r\n");
      out.write("        // alert(query);\r\n");
      out.write("        page=1;\r\n");
      out.write("        dataGet();\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    Handlebars.registerHelper('fmtDate', function (date) { //function(date)의 date는 datetime을 받아오는것이다.\r\n");
      out.write("        const yy = date.substring(2, 4); //0부터 4번앞에까지\r\n");
      out.write("        const mm = date.substring(5, 7);\r\n");
      out.write("        const dd = date.substring(8, 10);\r\n");
      out.write("        const fmtdate = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yy}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('년');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('월');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("일`\r\n");
      out.write("        return fmtdate;\r\n");
      out.write("        // return date.substr(0,10);\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script> //글쓰기 보이기 안보이기 아이템을 안가져와도 되는이유는 메뉴에서 이미 가져오기때문이다.  //기본으로 숨겨놓고 아이디가 있으면 보이고 없으면 숨기기 한것.\r\n");
      out.write("    if (uid) {\r\n");
      out.write("        $(\"#divWrite\").show();\r\n");
      out.write("    }//그러니까 else가 사실 피료없다. \r\n");
      out.write("    // else{\r\n");
      out.write("    //     $(\"#divWrite\").hide();\r\n");
      out.write("    // }\r\n");
      out.write("</script>\r\n");
      out.write("    ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}