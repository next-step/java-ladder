package nextstep.ladder.domain;

import static nextstep.ladder.domain.Line.HORIZONTAL_LINE_OVERLAPPING_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("라인의 수평선이 겹치면 예외를 던진다.")
    void overlapping_horizontal_line_exception() {
        // given
        Line line = new Line(createPoints());
        Line targetLine = new Line(createTargetPoints());

        // when  // then
        assertThatThrownBy(() -> line.isOverlapping(targetLine))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(HORIZONTAL_LINE_OVERLAPPING_EXCEPTION);
    }

    private List<Boolean> createTargetPoints() {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        points.add(true);
        points.add(true);
        return points;
    }

    @Test
    @DisplayName("줄의 길이가 다르면 예외를 던진다.")
    void line_length_difference_exception() {
        // given
        Line line = new Line(createPoints());
        Line targetLine = new Line(List.of(false, true, false, true));

        // when // then
        assertThatThrownBy(() -> line.validateSameSizeAs(targetLine))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(Line.LINE_LENGTH_DIFFERENCE_EXCEPTION);
    }
}
