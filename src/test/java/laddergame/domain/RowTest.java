package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {
    @Test
    void 연속해서_State_true() {
        assertThatThrownBy(() -> new Row(true, true, false, false))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY.getMessage());
    }

    @Test
    void 정상() {
        assertThatNoException().isThrownBy(() -> new Row(true, false, true, false));
    }
}
