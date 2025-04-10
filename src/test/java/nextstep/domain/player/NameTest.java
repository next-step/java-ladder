package nextstep.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈 값으로 이름을 만들 수 없다.")
    public void checkEmptyNullName(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자보다 긴 이름을 만들 수 없다.")
    public void checkNameLength() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}