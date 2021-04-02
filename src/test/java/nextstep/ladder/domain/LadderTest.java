package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사다리 높이를 1 이상 지정하지 않으면 예외 처리한다.")
    void throwExceptionIfHeightIsInvalid() {
        assertThatThrownBy(() -> new Ladder(0, 2)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("사다리 너비를 2 이상 지정하지 않으면 예외 처리한다.")
    void throwExceptionIfWidthIsInvalid() {
        assertThatThrownBy(() -> new Ladder(1, 1)).isInstanceOf(RuntimeException.class);
    }

}
