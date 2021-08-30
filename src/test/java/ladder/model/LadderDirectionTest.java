package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 방향 테스트")
public class LadderDirectionTest {

    @DisplayName("사다리 방향이 양쪽으로 있으면 예외가 발생한다.")
    @Test
    void bothDirectionsExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderDirection(true, true))
                .withMessage("사다리 방향이 양쪽으로 있을 수 없습니다.");
    }
}
