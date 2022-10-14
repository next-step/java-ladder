package ladder.domain.line.v2;

import ladder.domain.position.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest
    @CsvSource(value = {
            "true,RIGHT",
            "false,NONE"
    })
    void first(boolean hasRight, Direction expected) {
        assertThat(Point.first(hasRight)).isEqualTo(new Point(new Position(0), expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,true,LEFT",
            "true,false,LEFT",
            "false,true,RIGHT",
            "false,false,NONE",
    })
    void next(boolean hasRight1, boolean hasRight2, Direction expected) {
        Point point = Point.first(hasRight1);
        assertThat(point.next(hasRight2)).isEqualTo(new Point(new Position(1), expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,LEFT",
            "false,NONE"
    })
    void last(boolean hasRight, Direction expected) {
        Point point = Point.first(hasRight);
        assertThat(point.last()).isEqualTo(new Point(new Position(1), expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,RIGHT,2",
            "1,LEFT,0",
            "1,NONE,1"
    })
    void move(int currentPosition, Direction direction, int expectedPosition) {
        Point point = new Point(new Position(currentPosition), direction);
        assertThat(point.move()).isEqualTo(new Position(expectedPosition));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT,true",
            "LEFT,false",
            "NONE,false"
    })
    void hasRight(Direction direction, boolean expected) {
        Point point = new Point(new Position(0), direction);
        assertThat(point.hasRight()).isEqualTo(expected);
    }
}
