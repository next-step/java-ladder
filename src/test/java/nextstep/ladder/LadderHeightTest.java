package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이가 1보다 작으면 예외가 발생한다.")
    void heightIsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> LadderHeight.of(0));
        assertThrows(IllegalArgumentException.class, () -> LadderHeight.of(-1));
    }
}
