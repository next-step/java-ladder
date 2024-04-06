package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.ConsciousPointPredicate;
import ladder.domain.Ladder.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointFactoryTest {

    @Test
    void generate_points() {
        assertThat(PointFactory.generatePoints(3, new ConsciousPointPredicate()))
                .isEqualTo(List.of(new Point(false), new Point(false)));
    }

    @Test
    void generate_points_by_boolean_array() {
        assertThat(PointFactory.generatePoints(new Boolean[]{true, false}))
                .isEqualTo(List.of(new Point(true), new Point(false)));
    }
}