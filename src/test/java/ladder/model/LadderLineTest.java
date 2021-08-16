package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 라인 테스트")
public class LadderLineTest {

    @DisplayName("사다리 라인의 포인트 개수가 1개 미만이면 예외가 발생한다.")
    @Test
    void pointCountLessThanMinExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.of(0))
                .withMessage("포인트 개수는 최소 1개 이어야 합니다.");
    }
}
