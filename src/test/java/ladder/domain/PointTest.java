package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

    @ParameterizedTest
    @CsvSource({"1, LEFT", "2, RIGHT", "3, PASS"})
    void 위치와_연결방향을_가진_포인트를_생성한다(int index, Direction direction) {
        Point point = Point.of(Position.from(index), direction);

        assertAll(
                () -> assertThat(point.getIndex().getPosition()).isEqualTo(index),
                () -> assertThat(point.getDirection()).isEqualTo(direction)
        );
    }

    @ParameterizedTest
    @CsvSource({"RIGHT", "PASS"})
    void 첫번째_위치의_포인트를_생성한다(Direction direction) {
        Point firstPoint = Point.makeFirstPoint(direction);
        Position position = Position.from(Point.FIRST_INDEX);

        assertThat(firstPoint).isEqualTo(Point.of(position, direction));
    }

    @Test
    void 다음_위치의_포인트를_생성한다() {
        Point currentPoint = Point.makeFirstPoint(Direction.PASS);
        Point nextPoint = currentPoint.makeNextPoint(Direction.RIGHT);

        Position nextPosition = Position.from(Point.FIRST_INDEX + 1);

        assertThat(nextPoint).isEqualTo(Point.of(nextPosition, Direction.RIGHT));
    }

    @ParameterizedTest
    @CsvSource({"RIGHT, LEFT", "LEFT, PASS", "PASS, PASS"})
    void 마지막_위치의_포인트를_생성한다(Direction currentDirection, Direction lastPointDirection) {
        Point currentPoint = Point.of(Position.from(2), currentDirection);
        Point lastPoint = currentPoint.makeLastPoint();

        assertThat(lastPoint).isEqualTo(Point.of(Position.from(3), lastPointDirection));
    }
}
