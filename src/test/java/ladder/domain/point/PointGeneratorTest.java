package ladder.domain.point;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.Position;
import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionStrategy;
import org.junit.jupiter.api.Test;

class PointGeneratorTest {

    private final Position zero = new Position(0);
    private final Position one = new Position(1);
    private final Point previous = new Point(zero, Direction.LEFT);
    private final PointGenerator pointGenerator = new PointGenerator(new DirectionStrategy(() -> 1));

    @Test
    void generateNextPoint_테스트() {
        assertThat(pointGenerator.generateNextPoint(previous, one))
            .isEqualTo(new Point(one, Direction.RIGHT));
    }

    @Test
    void generateLineStartPoint_테스트() {
        assertThat(pointGenerator.generateLineStartPoint())
            .isEqualTo(new Point(zero, Direction.RIGHT));
    }

    @Test
    void generateLineEndPoint_테스트() {
        Position end = new Position(3);
        assertThat(pointGenerator.generateLineEndPoint(previous, end))
            .isEqualTo(new Point(end, Direction.DOWN));
    }
}