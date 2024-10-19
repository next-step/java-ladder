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
        Users users = new Users(initUser());
        assertThat(users.getUsers())
                .hasSize(3)
                .extracting(User::getName)
                .containsExactly("홍길동", "전우치", "고길동");
    }

    @Test
    @DisplayName("실패 - 중복된 이름이 있는 유저목록으로 Users를 생성할 때 예외가 발생한다.")
    void throwExceptionWhenDuplicateUser() {
        List<User> findUsers = List.of(new User("홍길동"),
                new User("홍길동"),
                new User("전우치"));
        assertThatThrownBy(() -> new Users(findUsers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 같은 회원이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("실패 - getUsers 메서드가 반환된 List를 수정했을 때 예외가 발생한다.")
    void throwExceptionWhenModifyingReturnedList() {
        List<User> findUsers = new Users(initUser()).getUsers();
        assertThatThrownBy(() -> findUsers.add(new User("둘리")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("성공 - size 메서드가 유저의 수를 반환한다.")
    void sizeTest() {
        Users users = new Users(initUser());
        assertThat(users.size())
                .isEqualTo(initUser().size());
    }

    private List<User> initUser() {
        return List.of(new User("홍길동"),
                new User("전우치"),
                new User("고길동"));
    }
}
