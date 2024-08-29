package HASH.Blog.domain.user.service;

import HASH.Blog.domain.user.controller.dto.UserResponseDto;
import HASH.Blog.domain.user.domain.User;
import HASH.Blog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryUserService {
    private final UserRepository userRepository;

    public List<UserResponseDto> userReadAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserResponseDto::from)
                .toList();
    }
}
