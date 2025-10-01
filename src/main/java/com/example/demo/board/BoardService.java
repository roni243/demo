package com.example.demo.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardRequest.SaveDTO saveDTO) {
    }

    public List<Board> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }
}
