package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("User 생성 테스트")
    @Test
    void create_User_Test() {
        User user = User.of("pobi");
        assertThat(user).isEqualTo(User.of("pobi"));
    }

    @DisplayName("유저 이름이 5글자 이상일 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "pobipobi"})
    void nameLength_Exception_Test(String name) {
        assertThatThrownBy(() -> {
            User.of(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저 이름이 공백일 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void nameIsBalnk_Exception_Test(String name) {
        assertThatThrownBy(() -> {
            User.of(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}