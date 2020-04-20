package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    @DisplayName("유저 이름은 5글자 까지 부여")
    @ParameterizedTest
    @ValueSource(strings = {"yohan", "jo", "jayde", "tom"})
    void create(String input) {
        assertThat(new User(input)).isEqualTo(new User(input));
    }

    @DisplayName("유저 이름이 존재하지 않거나 5자리를 초과할 경우 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"nonoover5", "abcdefd", "", "123456"})
    void exceptByCreation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new User(input);
        });
    }
}
