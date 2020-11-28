package ladder.domain.point;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.Position;
import ladder.domain.direction.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PointTest {

    @ParameterizedTest
    @EnumSource(value = Direction.class)
    void next가로축_이동_테스트(Direction direction) {
        Position position = new Position(direction.ordinal() + 1);
        Point point = new Point(position, direction);

        Position computed = direction.getNextPosition(position);

        assertThat(point.goNextPoint()).isEqualTo(computed);
    }
}