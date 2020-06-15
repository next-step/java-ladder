package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @ParameterizedTest(name = "input = {0}")
    @NullAndEmptySource
    @DisplayName("이름은 null 이거나 빈문자열일 수 없다.")
    void validate_null_or_empty(String target) {
        assertThatThrownBy(() -> new Name(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null 이거나 빈 문자열일 수 없습니다.");
    }
}