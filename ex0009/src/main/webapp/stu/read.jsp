<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
table .title {
	backgound: gray;
	color: blue;
	text-align: center;
}
</style>





<div class="row">
	<div class="col">
		<div>
			<h1>학생정보</h1>
		</div>
		<table class="table table-bordered">
			<tr>
				<td class="title">학생번호</td>
				<td>${stu.scode}</td>
				<td class="title">학생이름</td>
				<td>${stu.sname}</td>
				<td class="title">학생학과</td>
				<td>${stu.sdept}</td>

			</tr>
			<tr>
				<td class="title">생년월일</td>
				<td>${stu.birthday}</td>
				<td class="title">학생학년</td>
				<td>${stu.year}</td>
				<td class="title">지도교수</td>
				<td>${stu.pname}(${stu.advisor})</td>

			</tr>
			<tr>
				<td class="title">꿈</td>
				<td></td>
				<td class="title">목표</td>
				<td></td>
				<td class="title">좌우명</td>
				<td></td>

			</tr>
		</table>
		<div class="text-center my-5">
			<button class="btn btn-info" id="update">학생수정</button>
			<button class="btn btn-danger" id="delete">학생삭제</button>
		</div>

	</div>
</div>
<script>

//수정버튼을 클릭할 경우
			
	$("#update").on("click", function(){
		const scode="${stu.scode}";	
		location.href="/stu/update?scode=" + scode;
		
		

	});


//삭제버튼을 클릭할 경우
	$("#delete").on("click", function(){
		const scode="${stu.scode}";
		if(confirm(scode + "번 학생을 삭제하실래요?")){
			//학생삭제
			$.ajax({
				type:"post",
				url:"/stu/delete",   //이게 말이되나???? 딜리트 jsp가 없는데 어떻게 요청을 받지??
				data:{scode},
				success:function(data){
					if(data=="true"){
						alert("삭제완료!!");
						location.href=="/stu/list"
					}else{
						alert("학생이 신청한 수강데이터가 존재합니다.");
					}
					
				}
				
				
			});
		}
	});







</script>

