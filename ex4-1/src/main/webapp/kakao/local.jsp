<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1>지역검색</h1>
</div>

<div class = "row mb-2">
    <form action="" class = "col-7 col-md-5" name="frm"> <!-- 서버에 넘길 떄 name으로 넘어가는거 알지? 그러니까 form은 그냥 name으로 변수지정하는거임.-->
        <div class = "input-group">
            <input name="query" class = "form-control" placeholder="검색하실 장소를 입력하세요" value="스키야키">
            <button class = "btn btn-primary">검색</button>
        </div>
    </form>
</div>
<div id = "divLocal" class="row"></div>
<div class = "text-center my-4"> <!-- my는 마직 y축이라는 뜻-->
    <button class = "btn btn-primary" id = "prev">이전</button>
    <span class = "mx-2" id = "page"><b>1</b></span> <!-- 같은줄에 하기위해 div아니고 span으로 한거임. -->
    <button class = "btn btn-danger" id = "next">다음</button>
</div>
<!-- 다음 버튼 밑에 지도 불러오기 -->
<div id="map"></div>
<script id = "tempLocal" type="x-handlebars-template">
    <table class="table table-dark table-striped table-hover">
        <tr>
            <td>장소명</td>
            <td>주소</td>
            <td>전화번호</td>
            <td>위치</td>
            <td>경도</td>
            <td>위도</td>
        </tr>
        {{#each documents}}
            <tr>
                <td>{{place_name}}</td>
                <td>{{address_name}}</td>
                <td>{{phone}}</td>
                <td><button x="{{x}}" y="{{y}}" address="{{address_name}}" class="btn btn-success btn-sm location">위치</button>
                <td>{{x}}</td>
                <td>{{y}}</td>
            </tr>
            <!-- <tr>
                <td colspan=2>{{body}}</td>
            </tr> -->
        {{/each}}
    </table>    
</script>

<script>
    let query=$(frm.query).val(); // jquery는 name을 가져올때 쌩으로 쓴다.
    let page = 1;
    dataGet();
    
    //위치버튼을 클릭한 경우 지도들고오기 
    $("#divLocal").on("click", ".location", function(){
        const x=$(this).attr("x"); // x값 들고오기
        const y=$(this).attr("y"); // y값 들고오기
        // alert(x + ":" + y);
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = { 
        center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
        };

        var map = new kakao.maps.Map(mapContainer, mapOption);

        // 마커가 표시될 위치입니다 
        var markerPosition  = new kakao.maps.LatLng(y, x); 

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        // 마커가 드래그 가능하도록 설정합니다 
        marker.setDraggable(true); 

        // 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다\
        var str = $(this).attr("address");
            str += "<br>"
            str += "<br>"
            
        var iwContent = '<div style="width: 100%;">' + str + '</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
            content : iwContent
        });

        // 마커에 마우스오버 이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'mouseover', function() {
        // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
            infowindow.open(map, marker);
        });

        // 마커에 마우스아웃 이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'mouseout', function() {
            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
            infowindow.close();
        });
    });
    



    //다음과 이전버튼
    $("#next").on("click", function(){//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자
        page++;
        dataGet();
    });
    $("#prev").on("click", function(){//page를 1업하고 싶은데 page의 변수가 없으니 전역변수로 하나 설정해주자
        page--;
        dataGet();
    });


    $(frm).on("submit", function(event){
        event.preventDefault();
        query = $(frm.query).val();
        if(query == ""){
            alert("검색어를 입력하세요");
        }else{
            page = 1;
            dataGet();
        }
    });

    function dataGet(){ //데이터를 가져오는 함수다.
        $.ajax({
            type:"get",
            url:"https://dapi.kakao.com/v2/local/search/keyword.json",
            dataType:"json",
            data:{query: query, size:10, page:page}, //어떤거 검색할건지
            headers:{"Authorization":"KakaoAK 89e3021ad2846184fd12b67daf705b0f"},
            success:function(data){
                // alert("성공~");
                console.log(data);
                const temp = Handlebars.compile($("#tempLocal").html()); // tempBook 템플릿을 html형식으로 컴파일해서 temp에 넣어주기
                $("#divLocal").html(temp(data)); //divBook에 컴파일한temp안에 데이터를 넣고 html형식의. 
                const last = Math.ceil(data.meta.pageable_count/10);
                $("#page").html(page + "/" +last);
                if(page == 1){
                    $("#prev").attr("disabled", true)
                }else{
                    $("#prev").attr("disabled", false)
                }
                if(data.meta.is_end){
                    $("#next").attr("disabled", true)
                }else{
                    $("#next").attr("disabled", false)
                }
            }
        });
    }
</script>
