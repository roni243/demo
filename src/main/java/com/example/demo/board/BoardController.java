package com.example.demo.board;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final HttpSession session;

    @GetMapping("/board/save")
    public String boardSaveForm(){
        return "board/save-form";
    }

    @PostMapping("/board")
    public String boardSave(BoardRequest.SaveDTO saveDTO) {
        boardService.save(saveDTO);
        return "redirect:/board";
    }

}
