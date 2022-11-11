package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WidthTest {
    @Test
    void 너비_1미만() {
        assertThatThrownBy(() -> new Width(0))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.WIDTH_UNDER_MINIMUM.getMessage());
    }

    @Test
    void 너비_1이상() {
        assertThatNoException().isThrownBy(() -> new Width(1));
    }
}
