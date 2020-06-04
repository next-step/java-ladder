package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"true, false"})
    @DisplayName("라인이 겹치는지 확인")
    void createLine(boolean preHasLine, boolean expected) {
        Line line = new Line(2);
        line.createLine(preHasLine, 0);

        boolean result = line.getPoints().get(1);
        assertThat(result).isEqualTo(expected);
    }
}
