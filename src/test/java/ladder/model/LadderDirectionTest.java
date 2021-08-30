package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

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

    @DisplayName("첫번째 사다리의 방향에서 왼쪽 방향은 false 이어야 한다.")
    @Test
    void leftOfFirstLadderDirectionTest() {
        // given, when, then
        assertSame(LadderDirection.first(true).isLeft(), false);
    }
}
