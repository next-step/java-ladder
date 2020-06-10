package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "3,3"})
    @DisplayName("옆에 다리 있을 경우 이동")
    void move(int location, int expected) {
        List<Boolean> points = Arrays.asList(false, true, false, false);
        Line line = new Line(points);

        int result = line.move(location);
        assertThat(result).isEqualTo(expected);
    }
}
