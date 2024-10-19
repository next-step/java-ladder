package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("실패 - getUsers 메서드가 반환된 List를 수정했을 때 예외가 발생한다.")
    void throwExceptionWhenModifyingReturnedList() {
        List<User> initUsers = List.of(new User("홍길동"),
                new User("전우치"),
                new User("고길동"));
        List<User> findUsers = new Users(initUsers).getUsers();
        assertThatThrownBy(() -> findUsers.add(new User("둘리")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
