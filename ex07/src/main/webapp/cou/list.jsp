<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	#size{
		width:100px;
		float: right;
	}
</style>



<div>
<h1>강좌관리</h1>
<div class="row">
	<div class="col-8 col-md-6">
		<form  name="frm">
			<div>
				<div class="input-group">
					<select name="key" class="form-select">   <!-- 아 이게 key 구나 -->
						<option value="lname">강좌이름</option>
						<option value="lcode">강좌번호</option>
						<option value="pname">담당교수</option>
						<option value="room">강의실</option>
					</select>
					<input name="word" placeholder="검색어" class="form-control ms-2">
					<button class="btn btn-info">검색</button>
					<span id="total class=mt-2 ms-3"></span>
				</div>
			</div>
		</form>
		
	</div>
	<div class="col">
	<select id="size" class="form-select">
		<option value="1">한아</option>
		<option value="2">두울</option>
		<option value="3">세엣</option>
		<option value="4">네엣</option>
		<option value="5" selected>다서엇</option>
	</select>
	</div>
	
</div>

	<div id="div_cou"></div>
	<div id="pagination" class="pagination justify-content-center mt-5"></div>
</div>
<script id="temp_cou" type="x-handlebars-template">
	<table class="table table-bordered table-hover">
		<tr class="text-center">
			<td>강좌번호</td>
			<td>강좌이름</td>
			<td>강의시간</td>
			<td>강의실</td>
			<td>신청인원</td>
			<td>담당교수</td>
		</tr>
		{{#each .}}
		<tr class="text-center">
			<td>{{lcode}} </td>
			<td>{{lname}} </td>
			<td>{{hours}} </td>
			<td>{{room}} </td>
			<td>{{persons}}/{{capacity}} </td>
			<td>{{pname}}/{{instructor}} </td>
		</tr>
		{{/each}}
	</table>
</script>

<script>

//size 변경될 때

	$("#size").on("change",function(){
		size=$("#size").val();
		page=1;
		getData();
	});


	let page=1;
	let size=5;
	let key="lname";
	let word="";
	
	
	//번쩍할 때
	$(frm).on("submit", function(e){
		e.preventDefault();
		page=1;  //page 1페이지로 리셋해주고 
		key=$(frm.key).val(); // 키는  벨류값으로
		word=$(frm.word).val();
		//getData();
		getTotal();
	});
	
	getData();
	function getData(){
		$.ajax({
			type:"get",
			url:"/cou/list.json",
			data:{page, size, key, word},
			dataType:"json",
			success:function(data){
				const temp=Handlebars.compile($("#temp_cou").html());
				$("#div_cou").html(temp(data));
			}
		});	
		
	}
	
	function getTotal(){
		$.ajax({
			type:"get",
			url:"/cou/total",
			data:{key,word},
			success:function(data){
				let total=parseInt(data);
				if(total==0) {
					alert("검색데이터없어");
					return;
				}
				$("#total").html("검색수: " + total);
				let totalPage=Math.ceil(total/size);
				$("#pagination").twbsPaggination("changeTotalPages",totalPage, page);
				
				if(total > size) {
					$("#pagination").show();
				}else{
					$("#pagination").hide();
				}
			
			}
		})
	}
	
	   $('#pagination').twbsPagination({
		      totalPages:10, 
		      visiblePages: 15, 
		      startPage : 1,
		      initiateStartPageClick: false, 
		      first:'<i class="bi bi-chevron-double-left"></i>', 
		      prev :'<i class="bi bi-chevron-left"></i>',
		      next :'<i class="bi bi-chevron-right"></i>',
		      last :'<i class="bi bi-chevron-double-right"></i>',
		      onPageClick: function (event, clickPage) {
		          page=clickPage; 
		          getData();
		      }
		   });
</script>