package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 라인 테스트")
public class LadderLineTest {

    @DisplayName("사다리 라인의 포인트 목록이 비었으면 예외가 발생한다")
    @Test
    void emptyLadderLineExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(null))
                .withMessage("포인트 목록이 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(new ArrayList<>()))
                .withMessage("포인트 목록이 비었습니다.");
    }
}
