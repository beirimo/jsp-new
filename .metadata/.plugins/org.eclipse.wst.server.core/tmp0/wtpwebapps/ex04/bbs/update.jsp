<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row justify-content-center">
	<div class="col-10">
		<h1>글수정 페이지</h1>
		<form class="p-5" name="frm" method="post" action="/bbs/update">
			<input name="writer" value="${user.uid}" type="hidden"> <input
				name="bid" value="${bbs.bid }" type="hidden"> <input
				type="text" placeholder="제목을 쓰세요" class="form-control mb-3"
				name="title" value="${bbs.title }">
			<textarea class="form-control" name="contents" cols="30" rows="12"
				placeholder="적어요 좀">${bbs.contents }</textarea>


			<div class="text-end mt-3">
				<button type="submit" class="btn btn-info px-4">수정</button>
				<button type="reset" class="btn btn-danger px-4">다시쓰기</button>

			</div>

		</form>

	</div>
</div>
<script>
----------------------여기서부터 하자 
</script>
