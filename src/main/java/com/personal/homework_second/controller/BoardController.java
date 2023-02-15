package com.personal.homework_second.controller;

import com.personal.homework_second.dto.BoardRequestDto;
import com.personal.homework_second.dto.BoardResponseDto;
import com.personal.homework_second.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 모든 들어오는 나가는 Json으로 나간다.
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class BoardController {

    // DI, Service 객체 불러오기
    private final BoardService boardService;

    // 모든 게시판 조회 API
    @GetMapping("/All_boards")
    public List<BoardResponseDto> allShow() {
        return boardService.allShow();
    }

    // Post 방식으로 게시판 추가 API
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto,
                                        HttpServletRequest request) {
        return boardService.createBoard(requestDto, request);
    }

    // Get 방식으로 선택한 게시글 조회 API
    @GetMapping("/boards/{id}")
    public BoardResponseDto selectShow(@PathVariable Long id) {
        return boardService.selectShow(id);
    }

    // Put 방식으로 선택한 게시글 수정 API
    @PutMapping("/boards/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id,
                                        @RequestBody BoardRequestDto requestDto,
                                        HttpServletRequest request) {
        return boardService.update(requestDto, request);
    }

    // Delete 방식으로 선택한 게시글 삭제 API
    @DeleteMapping("/boards/{id}")
    public String deleteBoard(@PathVariable Long id, HttpServletRequest request) {
        return boardService.delete(id, request);
    }

}