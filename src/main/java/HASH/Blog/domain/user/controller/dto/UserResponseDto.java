package HASH.Blog.domain.user.controller.dto;

import HASH.Blog.domain.user.domain.User;

public record UserResponseDto(
        Long id,
        String username,
        String userid,
        String password,
        String emai
) {
    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getUserid(), user.getPassword(), user.getEmail());
    }
}
