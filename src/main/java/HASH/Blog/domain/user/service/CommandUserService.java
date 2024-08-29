package HASH.Blog.domain.user.service;

import HASH.Blog.domain.user.controller.dto.UserRequestDto;
import HASH.Blog.domain.user.domain.User;
import HASH.Blog.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandUserService {

    private final UserRepository userRepository;

    public void createUser(UserRequestDto userRequestDto) {
        // 잉? 디티오를 유저로 변환..?
        User user = User.builder()
                .username(userRequestDto.username())
                .userid(userRequestDto.userid())
                .password(userRequestDto.password())
                .email(userRequestDto.email())
                .build();

        userRepository.save(user);
    }

    @Transactional
    public void updateUser(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        user.updateUser(userRequestDto);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        userRepository.delete(user);
    }
}
