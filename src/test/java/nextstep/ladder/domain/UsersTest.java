package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {
    @Test
    @DisplayName("성공 - getUsers 메서드가 유저 목록을 반환한다.")
    void getUsersTest() {
        Users users = initUser();
        assertThat(users.getUsers())
                .hasSize(3)
                .extracting(User::getName)
                .contains("홍길동", "전우치", "고길동");
    }

    @Test
    @DisplayName("실패 - getUsers 메서드가 반환된 List를 수정했을 때 예외가 발생한다.")
    void throwExceptionWhenModifyingReturnedList() {
        Set<User> findUsers = initUser().getUsers();
        assertThatThrownBy(() -> findUsers.add(new User("둘리")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("성공 - size 메서드가 유저의 수를 반환한다.")
    void sizeTest() {
        Users users = initUser();
        assertThat(users.size())
                .isEqualTo(initUser().size());
    }

    private Users initUser() {
        return Users.from(new LinkedHashSet<>(List.of("홍길동", "전우치", "고길동")));
    }
}
