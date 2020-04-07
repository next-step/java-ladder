package nextstep.ladder.domain.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @DisplayName("사다리 다리 정상 생성")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,2"})
    void create(int linePosition, int stepPosition) {
        assertThatCode(() -> Row.of(linePosition, stepPosition))
                .doesNotThrowAnyException();
    }

    @DisplayName("위치가 음수 일때 생성 실패")
    @ParameterizedTest
    @CsvSource(value = {"-1,2", "2,-1"})
    void createFailByNegative(int linePosition, int stepPosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> Row.of(linePosition, stepPosition));
    }
}