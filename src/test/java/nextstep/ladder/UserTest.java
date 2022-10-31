package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.domain.User;

public class UserTest {

    @DisplayName("이름 길이가 5자 이상이면 예외를 발생시키는 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "abcde", "ddddd" })
    void user_name_length_validate_test(String name) {
        assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 미만이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "a", "ddddd", "테스트" })
    void user_name_length_test(String name) {
        assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 미만이어야 합니다.");
    }
}
