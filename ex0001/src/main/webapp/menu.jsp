<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">about</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            자주쓰는 도구
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" target="_black" href="https://finance.naver.com/">주식정보</a></li>
            <li><a class="dropdown-item" target="_black" href="https://getbootstrap.kr/" >부트스트랩</a></li>
             <li><a class="dropdown-item" target="_black" href="https://github.com/helen-cho">Helper</a></li>
            <li><hr class="dropdown-divider"> </li>
            <li><a class="dropdown-item" target="_black" href="https://chat.openai.com/c/18e3a208-db95-4269-a1c8-7b190d8f79ad">chat GPT</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            카카오맵
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">지도찾기</a></li>
            <li><a class="dropdown-item" href="#">지점찾기</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">주소검색</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            게시판
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">로그</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            학교관리 
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/stu/update">학생관리</a></li>
            <li><a class="dropdown-item" href="/stu/insert">학생등록</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/pro/update">교수관리</a></li>
            <li><a class="dropdown-item" href="/pro/insert">교수등록</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/user/login">로그인 </a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>