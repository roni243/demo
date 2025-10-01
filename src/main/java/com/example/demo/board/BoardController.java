package com.example.demo.board;

import com.example.demo.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;


//    @GetMapping("/")
//    public String home() {
//        return "board/list";
//    }

    @GetMapping("/board")
    public String boardList(Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<BoardResponse.ListDTO> boards = boardService.findAll();
        model.addAttribute("models", boards);
        model.addAttribute("sessionUser", sessionUser);
        return "board/list";
    }

    @GetMapping("/board/save-form")
    public String boardSaveForm(){
        return "board/save-form";
    }

    @PostMapping("/board/save")
    public String boardSave(BoardRequest.SaveDTO saveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        boardService.save(saveDTO, sessionUser);
        return "redirect:/board";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable("id") int id, Model model) {
        BoardResponse.DetailDTO board = boardService.findById(id);
        model.addAttribute("model", board);
        return "board/detail";
    }

    @GetMapping("/board/{id}/update-form")
    public String boardUpdateForm(@PathVariable("id") int id, Model model) {
        BoardResponse.DetailDTO board= boardService.findById(id);
        model.addAttribute("model", board);

        return "board/update-form";

    }

}
