package HASH.Blog.domain.board.controller.dto;

import jakarta.validation.constraints.NotNull;

public record BoardRequestDto (
        String title,
        String content
) {

}
