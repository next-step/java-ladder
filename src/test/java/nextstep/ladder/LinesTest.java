package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @ParameterizedTest
    @CsvSource(value = {"1", "2"})
    void 시작_포지션_값을_통해_최종_포지션_값을_구할_수_있다(int startPosition, int finalPosition) {
        Lines lines = new Lines(List.of());
        assertThat(lines.finalPosition(startPosition)).isEqualTo(finalPosition);

    }
}
