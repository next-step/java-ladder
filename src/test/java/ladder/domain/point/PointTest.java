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
}
