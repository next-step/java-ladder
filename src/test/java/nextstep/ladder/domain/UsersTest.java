package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    private Users initUser() {
        return Users.from(new LinkedHashSet<>(List.of("홍길동", "전우치", "고길동")));
    }
}
