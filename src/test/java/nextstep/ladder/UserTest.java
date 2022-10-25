package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.domain.User;

public class UserTest {

    @ParameterizedTest
    @ValueSource(strings = { "abcde, ddddd" })
    void user_name_length_test(String name) {
        assertThatThrownBy(() -> new User(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 미만이어야 합니다.");
    }
}
