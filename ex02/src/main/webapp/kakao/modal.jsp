<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="modal{{@index}}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
<div class="modal-dialog modal-xl">
    <div class="modal-content">
    <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">{{title}}</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    </div>
    <div class="modal-body">
        <div>제목 : {{title}}</div>
        <div>소개 : {{contents}}</div>
        <div>정가 : {{price}}</div>
        <div>판매가 : {{sale_price}}</div>
        <div>저자 : {{authors}}</div>
        <div>출판사 : {{publisher}}</div>
        <div>출판일 : {{datetime}}</div>
        <div>상태 : {{status}}</div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <!-- <button type="button" class="btn btn-primary">Understood</button> -->
    </div>
    </div>
</div>
</div>