<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row justify-content-center">
	<div class="col"></div>
	<h2>로그인</h2>
</div>

<div>
 <!--  <div class="card-body"-->
	<form name="frm" >
		<div class= "input-group mb-3">
			<span class="input-group-text justify-content-center">아이디</span> 
			<input class="form-control" name="uid" placeholder="ID">
		</div>

		<div class= "input-group mb-1">
			<span class="input-group-text justify-content-center">비밀번호</span> 
			<input class="form-control" name="upass" placeholder="password">
		</div>
		<div >
			<button class="btn btn-info">로그인</button>
		</div>
	</form>

</div>


<script>

$(frm).on("submit", function(e){
	e.preventDefault();
	const uid=$(frm.uid).val();
	const upass=$(frm.upass).val();
	if(uid=-""){
		alert( "id빠졌자나...")
		$(frm.uid).val("");
		$(frm.uid).focus();
	}else if (upass==""){
		alert("password 빠졌자나...")
	}
}

	
</script>