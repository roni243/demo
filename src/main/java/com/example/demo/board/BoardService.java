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

    @Transactional
    public void update(int id, String title, String content) {
        boardRepository.update(id, title, content);
    }

    public void delete(int id, User sessionUser) {
        BoardResponse.DetailDTO board;

        try {
            board = boardRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!sessionUser.getId().equals(board.getId())) {
            throw new IllegalArgumentException("본인의 게시글만 삭제할 수 있습니다");
        }

        boardRepository.deleteById(id);
    }
}
