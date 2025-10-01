package com.example.demo.board;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final HttpSession session;



}
