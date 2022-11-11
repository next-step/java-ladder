package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        Name name = new Name("수정");
        assertThat(name).isEqualTo(new Name("수정"));
    }

    @DisplayName("이름이 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsBlank(String input) {
        assertThatThrownBy(() -> {
            new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자를 넘으면 예외가 발생한다.")
    @Test
    void validateNameLength() {
        assertThatThrownBy(() -> {
            new Name("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
