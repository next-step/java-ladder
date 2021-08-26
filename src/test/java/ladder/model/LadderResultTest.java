package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 결과 테스트")
public class LadderResultTest {

    @DisplayName("사다리 결과가 비어있으면 예외가 발생한다.")
    @Test
    void emptyLadderResultExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderResult.of(""))
                .withMessage("사다리 결과가 비었습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderResult.of(null))
                .withMessage("사다리 결과가 비었습니다.");
    }

    @DisplayName("사다리 결과값은 생성시 주입받은 값 그대로 정상 생성되어야 한다.")
    @Test
    void createLadderResultTest() {
        // given, when
        LadderResult result = LadderResult.of("1000");

        // then
        assertEquals(result.getResult(), "1000");
    }

    @DisplayName("사다리 결과값이 같은 객체가 기존에 존재하면, 기존 객체를 재사용해야 한다.")
    @Test
    void reuseLadderResultTest() {
        // given, when, then
        assertSame(LadderResult.of("1000"), LadderResult.of("1000"));
    }
}
