package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @Test
    void 높이_1_미만() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.HEIGHT_UNDER_MINIMUM.getMessage());
    }

    @Test
    void 높이_1_이상() {
        assertThatNoException().isThrownBy(() -> new Height(1));
    }
}
