package com.example.boards.controller;

import com.example.boards.dto.BoardDto;
import com.example.boards.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/article")
    public String articleForm() {
        return "article";
    }

    @PostMapping("/boards/article")
    public String article(@ModelAttribute BoardDto boardDto) {
        System.out.println("boardDto = " + boardDto );
        boardService.article(boardDto);
        return "index";
    }

    @GetMapping("boards/")
    public String findAll(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

    @GetMapping("/boards/{id}")
    public String findById(@PathVariable Long id, Model model) {
//        게시글 데이터를 가져와서 detail.html
        BoardDto boardDto = boardService.finById(id);
        model.addAttribute("board", boardDto);
        return "detail";
    }

    @GetMapping("boards/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.finById(id);
        model.addAttribute("boardUpdate", boardDto);
        return "update";
    }

    @PostMapping("/boards/update")
    public String update(@ModelAttribute BoardDto boardDto, Model model) {
        BoardDto board = boardService.update(boardDto);
        model.addAttribute("board", board);
        return "detail";
    }

    @GetMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/boards/";
    }
}
