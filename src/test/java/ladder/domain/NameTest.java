package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값을 할당하는 경우 Name 객체를 생성하는데 실패한다.")
    void create_with_empty_value(final String value) {
        assertThatThrownBy(() -> new Name(value)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("5자를 초과하는 값을 할당하는 경우 Name 객체를 생성하는데 실패한다.")
    void create_with_over_5_letters() {
        assertThatThrownBy(() -> new Name("scappy")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("5자 이하의 이름만 입력 가능합니다.");
    }
}