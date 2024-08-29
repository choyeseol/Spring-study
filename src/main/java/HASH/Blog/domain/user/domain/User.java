package HASH.Blog.domain.user.domain;

import HASH.Blog.domain.user.controller.dto.UserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Timer;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String userid;

    private String password;

    private String email;

    @Builder
    public User(String userid, String username, String password, String email) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
    }   

    public void updateUser(UserRequestDto userRequestDto) {
        this.userid = userRequestDto.userid();
        this.username = userRequestDto.username();
        this.password = userRequestDto.password();
        this.email = userRequestDto.email();
    }
}
