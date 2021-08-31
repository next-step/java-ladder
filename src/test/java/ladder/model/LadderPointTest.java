package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 포인트 테스트")
public class LadderPointTest {

    @DisplayName("포인트 인덱스가 0 미만이면 예외가 발생한다.")
    @Test
    void minLadderPointIndexExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderPoint(-1, new LadderDirection(false, false)))
                .withMessage("포인트 인덱스는 0이상 이어야 합니다.");
    }
}
