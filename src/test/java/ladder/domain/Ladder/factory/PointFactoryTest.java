package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointFactoryTest {

    @Test
    void generate_points() {
        Point first = Point.first(false);

        assertThat(PointFactory.generatePoints2(3, () -> false))
                .isEqualTo(List.of(first, first.next(false)));
    }

    @Test
    void generate_points_by_boolean_array() {
        Point first = Point.first(true);

        assertThat(PointFactory.generatePoints2(new Boolean[]{true, false}))
                .isEqualTo(List.of(first, first.next(false)));
    }
}