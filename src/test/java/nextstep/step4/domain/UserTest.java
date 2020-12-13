package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    void createUser() {
        String name = "java";
        User user = User.of(0, name);
        assertThat(user.toString()).isEqualTo(name);
    }

    @Test
    @DisplayName("유저 이름이 5글자가 넘을 경우 예외 처리")
    void exceptNameLength() {
        String name = "abcdef";
        assertThrows(IllegalArgumentException.class,
                () -> User.of(0, name));
    }

    @Test
    @DisplayName("유저 이름이 빈 경우 예외 처리")
    void exceptNameEmpty() {
        String name = "";
        assertThrows(IllegalArgumentException.class,
                () -> User.of(0, name));
    }
}