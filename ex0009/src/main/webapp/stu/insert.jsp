<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<style>
.input-group span {
	width 150px;
	
}
</style>
<div class="row my-5 justify-content-center">
	<div class="col-10 col-md-8">
		<div class="card">
			<div class="card-header">
				<h3 class="text-center">학생등록</h3>
			</div>
		</div>
		<div>
			<form name="frm">
				<div class="input-group mb-2">
					<span class="input-group-text justify-centent-center">학생번호</span> <input
						name="scode" class="form-control" value="${code}" readonly>
					<!-- 왜 scode가 아니라 그냥 코드라고 되어있찌? -->
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text justify-centent-center">학생이름</span> <input
						name="scode" class="form-control">
					<!-- 왜 scode가 아니라 그냥 코드라고 되어있찌? -->
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text justify-centent-center">학생학과</span> <select
						class="from-select" name="dept">
						<!-- 왜 scode가 아니라 그냥 코드라고 되어있찌? -->
						<option value="전산">컴퓨터정보공학과</option>
						<option value="전자">전자공학과</option>
						<option value="건축">건축공학과</option>
					</select>
				</div>
				<div>
					<span class="input-group-text">학생학년</span>
					<div class="form-check m-2">
						<input value="1" name="year" class="form-check-input" type="radio">
						<label class="form-check">1학년</label>
					</div>
					<div class="form-check m-2">
						<input value="2" name="year" class="form-check-input" type="radio">
						<label class="form-check">2학년</label>
					</div>
					<div class="form-check m-2">
						<input value="3" name="year" class="form-check-input" type="radio">
						<label class="form-check">3학년</label>
					</div>
					<div class="form-check m-2">
						<input value="4" name="year" class="form-check-input" type="radio">
						<label class="form-check">4학년</label>
					</div>

				</div>
				<div class="input-group mb-2 ">
					<span class="input-group-text justify-content-center">지도교수</span> <input
						name="advisor" class="form-control" placeholder="교수번호" readonly>
					<input name="pname" class="form-control" placeholder="교수이름"
						readonly>

					<button class="btn btn-info" type="button" id="search">검색</button>
				</div>


				<div class="input-group mb-2">
					<span class="input-group-text">생년월일</span> <input name="birthday"
						class="form-control" type="date" value="2005-03-02">
				</div>

				<div class="text-center mt-3">
					<button class="btn btn-primary">학생등록</button>
					<button class="btn btn-danger" type="reset">등록취소</button>
				</div>

			</form>
		</div>

	</div>
</div>

<jsp:include page="modal.jsp"/>

<script>

		//검색버튼을 클릭했을 경우
		
		$("#search").on("click", function(){
			$("#modal").modal("show");
		});
		
		$(frm).on("submit", function(e){
			e.preventDefault();
			const sname=$(frm.pname).val();
			if(sname=="" || advisor==""){
				alert("학생이름과 지도교수를 입력하세요!");
				$(frm.sname).focus();
				return;
			}
			if(confirm("새로운 학생을 등록하실래요?")){
				frm.method="post";
				frm.submit();
			}														
		});
					
</script>