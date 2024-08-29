package HASH.Blog.domain.user.repository;

import HASH.Blog.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
