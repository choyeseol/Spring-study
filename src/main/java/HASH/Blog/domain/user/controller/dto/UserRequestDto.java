package HASH.Blog.domain.user.controller.dto;

public record UserRequestDto (
        String username,
        String userid,
        String password,
        String email
) {

}
