package com.example.demo.board;

import com.example.demo.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final HttpSession session;


    @GetMapping("/")
    public String home() {
        return "board/list";
    }

    @GetMapping("/board")
    public String boardList(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<Board> boards = boardService.findAll();
        model.addAttribute("models", boards);
        model.addAttribute("sessionUser", sessionUser);
        return "board/list";
    }

    @GetMapping("/board/save")
    public String boardSaveForm(){
        User SessionUser = (User) session.getAttribute("sessionUser");
        List<Board> boards = boardService.findAll();

        return "board/save-form";
    }

    @PostMapping("/board")
    public String boardSave(BoardRequest.SaveDTO saveDTO) {
        boardService.save(saveDTO);
        return "redirect:/board";
    }

}
