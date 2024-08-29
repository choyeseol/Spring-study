package HASH.Blog.domain.board.controller.dto;

import HASH.Blog.domain.board.domain.Board;

public record BoardResponseDto(
        Long id,
        String title,
        String content
) {

    public static BoardResponseDto from(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContent());
    }
}
