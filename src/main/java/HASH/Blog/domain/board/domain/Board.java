package HASH.Blog.domain.board.domain;

import HASH.Blog.domain.board.controller.dto.BoardRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    private String filename;

    private String filepath;

    @Builder
    public Board(String title, String content, String filename, String filepath) {
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.filepath = filepath;
    }

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.title();
        this.content = boardRequestDto.content();
    }
}