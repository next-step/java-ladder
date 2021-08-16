package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
public class LadderTest {

    @DisplayName("사다리 게임의 참가자 수가 2명 미만이면 예외가 발생한다.")
    @Test
    void playerCountLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(1, 5))
                .withMessage("참가자 수는 최소 2명 이어야 합니다.");
    }

    @DisplayName("사다리의 높이가 1 미만이면 예외가 발생한다.")
    @Test
    void ladderHeightLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(5, 0))
                .withMessage("사다리 높이는 최소 1 이어야 합니다.");
    }
}
