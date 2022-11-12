package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    void create() {
        User user = new User("수정");
        assertThat(user).isEqualTo(new User("수정"));
    }

    @DisplayName("이름이 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsBlank(String input) {
        assertThatThrownBy(() -> {
            new User(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자를 넘으면 예외가 발생한다.")
    @Test
    void validateNameLength() {
        assertThatThrownBy(() -> {
            new User("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
