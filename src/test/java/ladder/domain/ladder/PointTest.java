package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @ParameterizedTest
    @CsvSource("true,true")
    @DisplayName("before/after은 동시에 true일 수 없다.")
    void point(boolean before, boolean after) {
        assertThatThrownBy(() -> Point.of(before, after))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point 전/후로 가로 라인이 존재할 수 없습니다.");

    }
}