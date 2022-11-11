package laddergame.domain;

import laddergame.ManualGenerator;
import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 사다리_생성() {
        assertThat(new Height(2).createLadder(new Width(2),
                new ManualGenerator(true, false, false, true)))
                .isEqualTo(new Ladder(
                        new Row(true, false),
                        new Row(false, true))
                );
    }
}
