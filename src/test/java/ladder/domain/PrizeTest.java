package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PrizeTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값을 할당하는 경우 Prize 객체를 생성하는데 실패한다.")
    void create_with_empty_value(final String value) {
        assertThatThrownBy(() -> new Prize(value, 1)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("0 미만의 값을 할당하는 경우 Prize 객체를 생성하는데 실패한다.")
    void create() {
        assertThatThrownBy(() -> new Prize("꽝", -1)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0 이상의 값만 입력 가능합니다.");
    }
}