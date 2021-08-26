package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 결과 테스트")
public class LadderResultTest {

    @DisplayName("사다리 결과가 비어있으면 예외가 발생한다.")
    @Test
    void emptyLadderResultExceptionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(""))
                .withMessage("사다리 결과가 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(null))
                .withMessage("사다리 결과가 비었습니다.");
    }
}
