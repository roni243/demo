package com.example.demo.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardRequest.SaveDTO saveDTO) {
    }
}
