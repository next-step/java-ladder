package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import laddergame.util.ManualValueGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:2", "2:1"}, delimiter = ':')
    void 사다리_라인따라_움직인_후_위치_구하기(int index, int expected) {
        assertThat(new Line(false, true).move(index)).isEqualTo(expected);
    }
}
