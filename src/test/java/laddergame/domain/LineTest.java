package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import laddergame.util.ManualValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void 연속해서_State_true() {
        assertThatThrownBy(() -> new Line(true, true, false, false))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY.getMessage());
    }

    @Test
    void 정상() {
        assertThatNoException().isThrownBy(() -> new Line(true, false, true, false));
    }

    @Test
    void 너비만큼_Point_생성() {
        assertThat(Line.create(new Width(2), new ManualValueGenerator(true, false)))
                .isEqualTo(new Line(true, false));
    }
}
