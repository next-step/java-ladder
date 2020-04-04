package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 Exception 처리를 한다.")
    void assertLadderHeight() {
        int height;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(height);
        }).withMessage("사다리 높이는 1보다 커야합니다.")
    }
}
