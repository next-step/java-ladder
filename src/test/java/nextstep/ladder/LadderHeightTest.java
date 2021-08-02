package nextstep.ladder;

import nextstep.ladder.exception.IllegalLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @DisplayName("사다리 높이는 0보다 큰 숫자여야 한다.")
    @Test
    void min_ladder_height() {
        assertThatThrownBy(() -> LadderHeight.of(0))
                .isInstanceOf(IllegalLadderHeightException.class);
    }
}