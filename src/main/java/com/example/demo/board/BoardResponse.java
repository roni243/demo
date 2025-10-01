package com.example.demo.board;

import lombok.Data;

import java.sql.Timestamp;

public class BoardResponse {

    @Data
    public static class ListDTO {
        private int id;
        private String title;

        public ListDTO(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public int getId() {return id;}
        public String getTitle() {return title;}
    }


    @Data
    public static class DetailDTO {
        public int id;
        public String title;
        public String content;
        public Timestamp created;
        public Integer userId;
        public String username;

        public DetailDTO(int id, String title, String content, Timestamp created, Integer userId, String username) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.created = created;
            this.userId = userId;
            this.username = username;
        }

        public DetailDTO(Integer id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }
    }
}
