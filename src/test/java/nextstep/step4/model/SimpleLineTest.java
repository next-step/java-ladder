package nextstep.step4.model;

import nextstep.step4.api.Line;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
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

    @Test
    void 라인정보가_널이거나_비어있는경우_예외를던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SimpleLine(null));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SimpleLine(Collections.emptyList()));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "0:1", "2:2"}, delimiter = ':')
    void move(int position, int expected) {
        List<Point> points = Arrays.asList(Point.first(true), Point.first(true).next(), Point.first(true).next().last());

        Line line = new SimpleLine(points);

        assertThat(line.move(position)).isEqualTo(expected);
    }
}
