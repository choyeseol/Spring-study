package HASH.Blog.domain.user.controller;

import HASH.Blog.domain.user.controller.dto.UserRequestDto;
import HASH.Blog.domain.user.controller.dto.UserResponseDto;
import HASH.Blog.domain.user.service.CommandUserService;
import HASH.Blog.domain.user.service.QueryUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CommandUserService commandUserService;
    private final QueryUserService queryUserService;

    @GetMapping
    public List<UserResponseDto> userReadAll() {
        return queryUserService.userReadAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserRequestDto userRequestDto) {
        commandUserService.createUser(userRequestDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        commandUserService.updateUser(userRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        commandUserService.deleteUser(id);
    }
}
