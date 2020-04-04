package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height = 0;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(height);
        }).withMessage(Ladder.LADDER_HEIGHT_ERROR);
    }
}
