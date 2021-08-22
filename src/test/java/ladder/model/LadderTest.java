package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
public class LadderTest {

    @DisplayName("사다리의 높이가 1 미만이면 예외가 발생한다.")
    @Test
    void ladderHeightLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(5, 0))
                .withMessage("사다리 높이는 최소 1 이어야 합니다.");
    }

    @DisplayName("빈 가로 구간이 존재하면 예외가 발생한다.")
    @Test
    void emptyVerticalIntervalExceptionTest() {
        // given
        LadderLine firstLine = new LadderLine(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
        LadderLine secondLine = new LadderLine(Arrays.asList(Boolean.FALSE, Boolean.FALSE));

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(Arrays.asList(firstLine, secondLine)))
                .withMessage("빈 가로 구간이 존재하면 안됩니다.");
    }
}
