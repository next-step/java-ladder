package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        // given
        String nameString = "snow";

        // when
        Name name = Name.from(nameString);

        // then
        assertThat(name).isEqualTo(Name.from(nameString));
    }

    @Test
    @DisplayName("이름 5자 초과시 예외 발생한다.")
    void validate_name_length() {
        assertThatThrownBy(() -> Name.from("soonho"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("이름에 공백을 입력하면 예외 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_name_blank(String input) {
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(RuntimeException.class);
    }
}