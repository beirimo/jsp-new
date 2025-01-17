<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div class="mt-5 text-end", class="div_insert">
   <textarea rows="5" cols="" class="form-control" placeholder="댓글 입력하세요 ."></textarea>
   <button class="btn btn-primary">>취소</button>
   <button class="btn btn-info">답글 등록</button>
   
   </div> 
   <div class="", id="div_login">
   	<button class="btn btn-primary w-100 login">로그인 </button>
   	
   </div>
    
<div class="card mt-2">
	<div class="card-body">
	<div class="card-header"></div>
		<div id="div_comments"></div>
		
	</div>
</div>
<div id="pagination" class="pagination justify-content-center mt-5"></div>
<script id="temp_comments" type="x-handlebars-template">
	{{#each .}}
		<div class="mb-5"><b>{{cid}}</b>: {{contents}}</div>
	{{/each}}
</script>

<script>
	const bid="${bbs.bid}";
	let page=1;
	let size=3;
	
	if(uid){
		$("#div_insert").show();
		$("#div_login").hide();
	}else{
		$("#div_insert").hide();
		$("#div_login").show();
	}
	
	//로그인을 클릭한 경우
	
	$("#div_login").on("click", ".login", function(){
		sessionStorage.getItem("target", "/bbs/read?bid=" + bid");
		location.href="/user/login";
	});
	
	//등록버튼을 클릭한 경우
	
	$("#div_insert").on("click", ".insert", function(){
		const contents=$("#contents").val();
		if(contents==""){
			alert("댓글내용을 입력하세요");
			$("#contents").focus();
			return;
		}
		alert(contents + "\n" + bid + "\n" +uid);
	});
	
	
	getData();
	function getData(){
		$.ajax({
			type:"get",
			url:"/com/list.json",
			data:{bid, page, size},
			dataType:"json",
			success:function(data){
				const temp=Handlebars.compile($("#temp_comments").html());
				$("#div_comments").html(temp(data));
			}
		});
	}
	
	   getTotal();
	     function getTotal(){
	    	 $.ajax({
	    		 type:"get",
	    		 url:"/com/total",
	    		data:{bid},
	 		 success:function(data){
	 			const totalPage=Math.ceil(data/size);
	            	$("#pagination").twbsPagination("changeTotalPages", totalPage, page);
	            	$("#total").html("댓글수 :" + data + "건");
	 			 }   
	 		}
	    	 });	
	     }
</script>




