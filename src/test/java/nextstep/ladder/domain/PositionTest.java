package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    void validValue() {
        assertThatThrownBy(() -> Position.of(-1))
                .isInstanceOf(OutOfLineException.class);
    }
}
