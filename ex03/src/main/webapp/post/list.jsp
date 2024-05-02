<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="divPosts"></div> <!-- 밑에 스크립드들은 데이터출력을 위한 도구일뿐 결국 데이터는 여기에 들어오는것. -->

<script id="tempPosts" type="x-handlebars-template">
    <table class="table table-bordered table-dark" style ="text-align: center;">
        <tr>
            <td>번호</td><td>제목</td><td>작성자</td><td>작성일</td>
        </tr>
        {{#each documents}}
            <tr>
                <td>{{pid}}</td>
                <td><a href="/posts/read?pid={{pid}}" style = "text-decoration : none; color: white;">{{title}}</td></a>  <!-- 데이터가 넘어가는 링크를 걸어준다. -->
                <td>{{writer}}</td>
                <td>{{fdate}}</td>
            </tr>
        {{/each}}
    </table>
</script>

<div class = "row">
    <div class = "col-4 col-md-4 mt-3"><!-- 중간이상 해상도일대는 4칸-->
        <form action="" name="frm">
            <div class="input-group">
            <input type="text"class="form-control" placeholder="검색어를 입력하세요" name="query">
            <button class="btn btn-primary">검색</button>
            <span id="su" class="ps-3 pt-3"></span>
            </div>
        </form>
    </div>
    <div class="col text-end mt-3" id="divWrite" style="display:none;"> <!-- 아무튼 div안에 넣어야 만지기가 편하다. -->
        <a href="/posts/insert"><button class="btn btn-secondary">글쓰기 </button></a> <!--누르면 a태그의 지정된 곳으로 가자 -->
    </div>
</div>
<div class="text-center my-4"> <!-- my는 마진 y축이라는 뜻-->
    <button class="btn btn-primary" id="prev">이전</button>
    <span class="mx-2" id="page"><b>1</b></span> <!-- 같은줄에 하기위해 div아니고 span으로 한거임. -->
    <button class="btn btn-danger" id="next">다음</button>
</div>
<script> //ajax은 스크립트에서 쓴다.
    let page = 1; //시작페이지설정해주기 
    const size =15;
    let query="";
    dataGet();
    function dataGet() { //함수로 쓴이유는 여러번 해야하기때문에 
        $.ajax({ //데이터 호출시 ajax을 함수로 쓴다. 
            type: "get",
            url: "/post/list.json", // 로컬서버는 ~3000까지는 생략가능 
            dataType: "json",
            data: {page, size, query}, //page를 데이타로 넘겨주기 
            success: function (data) { //url의 데이터가 여기로 들어감 
                // alert("성공~");
                console.log(data);
                const temp = Handlebars.compile($("#tempPosts").html()); //아이디가 tempPosts인걸 html로 compile해서 temp에 저장 
                $("#divPosts").html(temp(data)); // temp에 data를 넣고  divPosts에 출력   
                $("#su").html(`<b>${data.su}<b>건이 검색되었습니다.`);
                const last = Math.ceil(data.su/size); //last를 정의해주기(페이지/마지막페이지를 할려고)
                $("#page").html(page + "/" + last); //데이터 불러오기 성공을 하면 #page를 출력해라  이거없으면 번호가 가감이 안된다. 
                if(page == 1){ //1페이지일대 이전버튼안눌리게하기
                    $("#prev").attr("disabled", true)
                }else{
                    $("#prev").attr("disabled", false)
                }
                if(page == last){ //마지막페이지가 다음안눌리게하기
                    $("#next").attr("disabled", true)
                }else{
                    $("#next").attr("disabled", false)
                }
            }
        });
    };
</script>


<script>
    
    //다음버튼 클릭
    $("#next").on("click", function () {//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자
        page++;
        dataGet();
    });
    $("#prev").on("click", function () {//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자
        page--;
        dataGet();
    });
    
    //검색창 submit안되게 하기
    $(frm).on("submit", function(e){ //frm 이 submit이벤트를  function(e)에 넣어줌. 
        e.preventDefault(); //e를 막아라.
        query=$(frm.query).val();
        // alert(query);
        page=1;
        dataGet();
    });

    Handlebars.registerHelper('fmtDate', function (date) { //function(date)의 date는 datetime을 받아오는것이다.
        const yy = date.substring(2, 4); //0부터 4번앞에까지
        const mm = date.substring(5, 7);
        const dd = date.substring(8, 10);
        const fmtdate = `${yy}년${mm}월${dd}일`
        return fmtdate;
        // return date.substr(0,10);
    });
</script>

<script> //글쓰기 보이기 안보이기 아이템을 안가져와도 되는이유는 메뉴에서 이미 가져오기때문이다.  //기본으로 숨겨놓고 아이디가 있으면 보이고 없으면 숨기기 한것.
    if (uid) {
        $("#divWrite").show();
    }//그러니까 else가 사실 피료없다. 
    // else{
    //     $("#divWrite").hide();
    // }
</script>
    