package nextstep.ladder.domain.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StepsTest {
    @DisplayName("라인 위치가 음수 일때 생성 실패")
    @ParameterizedTest
    @CsvSource(value = {"5,-2", "10,-3", "7,-5"})
    void createFailByNegativePosition(int height, int linePosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> Steps.firstLineSteps(height, linePosition));
    }
}
