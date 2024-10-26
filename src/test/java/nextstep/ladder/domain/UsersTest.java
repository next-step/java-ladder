package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;

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
    @DisplayName("성공 - size 메서드가 유저의 수를 반환한다.")
    void sizeTest() {
        Users users = initUser();
        assertThat(users.size())
                .isEqualTo(initUser().size());
    }

    @Test
    @DisplayName("실패 - findUserByName 메서드가 존재하지 않는 User 명을 입력받으면 예외가 발생한다.")
    void throwExceptionWhenNotExistUsername() {
        Users users = initUser();
        assertThatThrownBy(() -> users.findUserByName("없는이름"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 유저 입니다.");
    }

    @Test
    @DisplayName("성공 - findUserIndex 메서드가 회원의 순번을 반환한다.")
    void findUserIndexTest() {
        Users users = initUser();
        User user = new User("고길동");
        assertThat(users.findUserIndex(user)).isEqualTo(new Point(2));
    }

    private Users initUser() {
        return Users.from(new LinkedHashSet<>(List.of("홍길동", "전우치", "고길동")));
    }
}
