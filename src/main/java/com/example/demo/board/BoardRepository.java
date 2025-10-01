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
        Query query = em.createQuery("UPDATE Board b SET b.title = :title, b.content = :content WHERE b.id = :id");
        query.setParameter("title", title);
        query.setParameter("content", content);
        query.setParameter("id", id);
        query.executeUpdate();

    }

    public List<Board> findAll() {
        return em.createQuery("SELECT b FROM Board b", Board.class).getResultList();
    }

    public Board findById(int id) {
        Board board = em.createQuery("SELECT b FROM Board b WHERE b.id = :id", Board.class).setParameter("id", id).getSingleResult();
        return board;
    }

    public void deleteById(int id) {
        Query query = em.createQuery("DELETE FROM Board b WHERE b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }


}
