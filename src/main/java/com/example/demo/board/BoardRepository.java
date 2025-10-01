package com.example.demo.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        em.persist(board);
    }

    public void update(int id, String title, String content) {
        Query query = em.createQuery("UPDATE Board b SET b.title = :title, b.content = :content, WHERE b.id = :id");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, id);
    }

    public List<Board> findAll() {
        return em.createQuery("SELECT b FROM Board b", Board.class).getResultList();
    }

    public Board findById(int id) {
        Board board = em.createQuery("SELECT * FROM Board b WHERE b.id = :id", Board.class).setParameter(1, id).getSingleResult();
        return board;
    }

    public void deleteById(int id) {
        Query query = em.createQuery("DELETE FROM Board b WHERE id = :id");
        query.setParameter(1, id);
        query.executeUpdate();
    }


}
