package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {
    @DisplayName("사다리 높이가 1보다 작다.")
    @Test
    void 사다리_높이_1보다_작음() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ladder(0, new Participants("abcd,abc")))
                .withMessage("사다리 최고 높이는 1보다 작을 수 없습니다.");
    }
}
