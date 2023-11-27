package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @ParameterizedTest
    @DisplayName("줄에 수평선이 있는지 확인한다.")
    @CsvSource(value = {"1, false", "2, true"})
    void validate_horizontal_line(int point, boolean expected) {
        // given
        List<Boolean> points = createPoints();
        Line line = new Line(points);

        // when
        boolean result = line.hasHorizontalLine(point);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private List<Boolean> createPoints() {
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        return points;
    }
}
