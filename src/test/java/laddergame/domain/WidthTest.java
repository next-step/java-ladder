package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 플레이어수_빼기_1이_너비() {
        assertThat(new Width(new Players("a", "b", "c"))).isEqualTo(new Width(2));
    }
}
