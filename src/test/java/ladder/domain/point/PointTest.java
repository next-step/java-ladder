package ladder.domain.point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void createFirstPoint() {
        Point first = Point.first(() -> false);

        assertThat(first).isEqualTo(Point.first(() -> false));
    }

    @ParameterizedTest
    @CsvSource({"true, 1", "false,0"})
    void move(boolean strategy, int expect) {
        Point first = Point.first(() -> strategy);

        assertThat(first.move()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"true, false, 0", "false, true, 2", "false, false, 1"})
    void move_next(boolean firstStrategy, boolean nextStrategy, int expect) {
        Point point = Point.first(() -> firstStrategy);
        point = point.next(() -> nextStrategy);

        assertThat(point.move()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({"true, 0", "false, 1"})
    void move_last(boolean firstStrategy, int expect) {
        Point point = Point.first(() -> firstStrategy);
        point = point.last();

        assertThat(point.move()).isEqualTo(expect);
    }
}
