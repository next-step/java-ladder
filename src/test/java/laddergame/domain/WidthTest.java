package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import laddergame.util.ManualValueGenerator;
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
    void 열_생성() {
        assertThat(new Width(4).createRow(new ManualValueGenerator(true, false, false, false)))
                .isEqualTo(new Line(true, false, false, false));
    }
}
