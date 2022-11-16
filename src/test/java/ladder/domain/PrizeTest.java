package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PrizeTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값을 할당하는 경우 Prize 객체를 생성하는데 실패한다.")
    void create_with_empty_value(final String value) {
        assertThatThrownBy(() -> new Prize(value)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }
}