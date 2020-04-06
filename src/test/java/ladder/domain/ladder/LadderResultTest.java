package ladder.domain.ladder;

import ladder.domain.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderResultTest {
    @Test
    @DisplayName("결과 만들기")
    void constructorTest() {
        assertThat(LadderResult.ofComma("꽝,5000,꽝, 3000 ").getResults())
                .containsAnyOf("3000")
                .hasSize(4);
    }

    @Test
    @DisplayName("2개 미만 예외처리")
    void expectExceptionTest() {
        assertThatThrownBy(() -> LadderResult.ofComma("꽝"))
                .isInstanceOf(RuntimeException.class);
    }

}
