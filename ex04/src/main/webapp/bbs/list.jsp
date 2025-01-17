<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
<h1>자유 게시판.....</h1>
<div id="div_bbs"></div> <!-- 밑에 스크립드들은 데이터출력을 위한 도구일뿐 결국 데이터는 여기에 들어오는것. -->
</div>


<script id="temp_bbs"  type="x-handlebars-template">
    <table class="table table-bordered table-dark" style ="text-align: center;">
        <tr>
            <td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
        </tr>
        {{#each .}}
            <tr>
                <td>{{bid}}</td>
                <td><a href="/bbs/read?bid={{bid}}" style = "text-decoration : none; color: white;">{{title}}</td></a> <!-- 데이터가 넘어가는 링크를 걸어준다. -->
                <td>{{uname}}({{writer}})</td>
                <td>{{bdate}}</td>
            </tr>
        {{/each}}
    </table>


</script>
<script> //ajax은 스크립트에서 쓴다.
	let page = 1; //시작페이지설정해주기 
	let size = 5;
	let query ="";
	
	$(frm).on("submit", function(e){
		e.preventDefault();
		query=$(frm.querey).val();
		alert(query);
	});

	getData();
 	function getData() { //함수로 쓴이유는 여러번 해야하기때문에 
 		$.ajax({ //데이터 호출시 ajax을 함수로 쓴다. 
           		type: "get",
           	 	url: "/bbs/list.json", // 로컬서버는 ~3000까지는 생략가능 
           	 	dataType: "json",
           	 	data:{page, size, query},
           		success: function (data) { //url의 데이터가 여기로 들어감 
                		// alert("성공~");
                		const temp = Handlebars.compile($("#temp_bbs").html()); //아이디가 tempPosts인걸 html로 compile해서 temp에 저장 
                		$("#div_bbs").html(temp(data)); // temp에 data를 넣고  divPosts에 출력   
            	}
        	});
    	};

</script>

<script>

</script>

<div class="col text-end" id="divWrite" > <!-- 아무튼 div안에 넣어야 만지기가 편하다. -->
        <a href="/bbs/insert"><button class="btn btn-secondary">글쓰기 </button></a> <!--누르면 a태그의 지정된 곳으로 가자 -->
</div>

<script> //글쓰기 보이기 안보이기 아이템을 안가져와도 되는이유는 메뉴에서 이미 가져오기때문이다.  //기본으로 숨겨놓고 아이디가 있으면 보이고 없으면 숨기기 한것.
    if (uid) {
        $("#divWrite").show();
    }//그러니까 else가 사실 피료없다.  근데 jsp에서는 있어야 한다. 
     else{
         $("#divWrite").hide();
     }
     getTotal();
     function getTotal(){
    	 $.ajax({
    		 type:"get",
    		 url:"/bbs/total",
    		data:{query},
 		 success:function(data){
 			if(data ==0){
 				alert("검색내용 없네요.");
 				$(frm.query).val("");
 			}else{
 			const totalPage=Math.ceil(data/size);
            	$("#pagination").twbsPagination("changeTotalPages", totalPage, page);
            	$("#total").html("검색수 :" + data + "건");
 			 }   
 		}
    	 });	
     }
     //페이지네이션 출력
     $('#pagination').twbsPagination({
         totalPages:100, 
         visiblePages: 10, 
         startPage : 1,
         initiateStartPageClick: false, 
         first:'<i>처음</i>', 
         prev :'<i>이전</i>',
         next :'<i>다음</i>',
         last :'<i>마지막</i>',
         onPageClick: function (event, clickPage) {
             page=clickPage; 
             getData();
         }
      });
</script>

