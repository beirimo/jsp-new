<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.input-group span{
		width: 150px;
	}
</style>
<div class="row my-5 justify-content-center">
	<div class="col-10 col-md-8">
		<div class="card">
			<div class="card-header">
				<h3 class="text-center">강좌등록</h3>
			</div>
			<div class="card-body">
				<form name="frm">
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">강좌번호</span>
						<input name="lcode" class="form-control" value="${code}" readonly>
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">강좌이름</span>
						<input name="lname" class="form-control">
					</div>
				
					
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">담당교수</span>
						<input name="instructor" class="form-control" placeholder="교수번호" readonly>
						<input name="pname" class="form-control" placeholder="교수이름" readonly>
						
						<button class="btn btn-info" type="button" id="search">검색</button>  
					
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">최대수강인원</span>
						<input name="capacity" class="form-control" type="number" value="0">
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">강의실 </span>
						<input name="room" class="form-control" >
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text justify-content-center">강의시수</span>
						<input name="hours" class="form-control" type="number" value="2">
					</div>
					<div class="text-center mt-3">
						<button class="btn btn-primary">강좌등록</button>
						<button class="btn btn-secondary" type="reset">등록취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="modal.jsp"/>
<script>
	//검색버튼을 ㄱ클릭했을 경우 
	
	$("#search").on("click", function(){
		$("#modal").modal("show");
	});


	$(frm).on("submit", function(e){
		e.preventDefault();
		const lname=$(frm.lname).val();
		const instructor=$(frm.instructor).val();
		if(lname=="" || instructor==""){
			alert("강좌이름과 담당교수를 입력행 !");
			$(frm.lname).focus();
			return;
		}
		if(confirm("새로운 강의를 등록하실래요?")){
			frm.method="post";
			frm.submit();
		}
	});
</script>

