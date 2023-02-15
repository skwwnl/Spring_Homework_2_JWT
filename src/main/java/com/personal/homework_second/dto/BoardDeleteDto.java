package com.personal.homework_second.dto;


public class BoardDeleteDto {
    private String success;

    public BoardDeleteDto(){
        this.success = "삭제하였습니다";
    }

    public String getSuccess(){
        return success;
    }
}
