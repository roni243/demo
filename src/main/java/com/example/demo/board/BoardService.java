package com.example.demo.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.user.User;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardRequest.SaveDTO saveDTO, User sessionUser) {
        Board board = saveDTO.toEntity(sessionUser);
        boardRepository.save(board);
    }

    public List<BoardResponse.ListDTO> findAll() {
        List<BoardResponse.ListDTO> boards = boardRepository.findAll();
        return boards;
    }

    public BoardResponse.DetailDTO findById(int id) {
        BoardResponse.DetailDTO board = boardRepository.findById(id);
        return board;
    }
}
