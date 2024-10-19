package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {
    @Test
    @DisplayName("성공 - getUsers 메서드가 유저 목록을 반환한다.")
    void getUsersTest() {
        List<User> initUsers = List.of(new User("홍길동"),
                new User("전우치"),
                new User("고길동"));
        Users users = new Users(initUsers);
        assertThat(users.getUsers())
                .hasSize(3)
                .extracting(User::getName)
                .containsExactly("홍길동", "전우치", "고길동");
    }
}
