package nextstep.step4.model;

import nextstep.step4.api.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SimpleLineTest {
    /**
     * |-----|      |
     */
    @Test
    void create() {
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(), Point.first(true).next().last());
        Line line = new SimpleLine(points);
        assertThat(line).isEqualTo(new SimpleLine(points));
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 라인정보가_널이거나_비어있는경우_예외를던진다(List<Point> points) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SimpleLine(points));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "0:1", "2:2"}, delimiter = ':')
    void move(int position, int expected) {
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(), Point.first(true).next().last());

        Line line = new SimpleLine(points);

        assertThat(line.move(position)).isEqualTo(expected);
    }
}
