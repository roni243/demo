package com.example.demo.board;

public class BoardRequest {

    public static class SaveDTO {
        private String title;
        private String content;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
