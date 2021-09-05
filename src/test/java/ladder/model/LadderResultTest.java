package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리 실행 결과 테스트")
public class LadderResultTest {

    @DisplayName("사다리 실행 결과가 비어있으면 예외가 발생한다.")
    @Test
    void emptyLadderResultExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(""))
                .withMessage("사다리 실행 결과가 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResult(null))
                .withMessage("사다리 실행 결과가 비었습니다.");
    }

    @DisplayName("사다리 실행 결과는 생성시 주입받은 값 그대로 정상 생성되어야 한다.")
    @Test
    void createLadderResultTest() {
        // given, when
        LadderResult result = new LadderResult("1000");

        // then
        assertEquals(result.getResult(), "1000");
    }
}
