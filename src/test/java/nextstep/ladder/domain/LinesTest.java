package nextstep.ladder.domain;


import nextstep.ladder.exceptions.OutOfLadderSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LinesTest {

    @Test
    @DisplayName("사다리 범위를 넘는 값 조회 시 Exception")
    void outOfLadderSize() {
        Lines lines = new Lines(3, 4);
        assertThatExceptionOfType(OutOfLadderSizeException.class)
                .isThrownBy(() -> lines.lines(4, 3))
                .withMessage("사다리 범위를 넘는 값 조회입니다.");
    }
}