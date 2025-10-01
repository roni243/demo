package com.example.demo.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findByUsername(String username) {
        return em.createQuery("select u from User u where u.username = :username", User.class)
            .setParameter("username", username)
            .getSingleResult();
    }
}
