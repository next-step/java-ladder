package ladder.domain.Ladder;

import ladder.domain.participants.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    Position positionZero = new Position(0);
    Position positionFirst = new Position(1);

    @Test
    void generate_first() {
        assertThat(Point.first(false).move(positionZero)).isEqualTo(positionZero);
    }

    @Test
    void generate_next() {
        assertThat(Point.first(false).next(true).move(positionZero)).isEqualTo(positionFirst);
    }

    @Test
    void validate_point() {
        assertThat(Point.first(true).next(true)).isEqualTo(Point.first(true).next(false));
    }

    @Test
    void move_left() {
        assertThat(Point.first(true).next(false).move(positionFirst)).isEqualTo(positionZero);
    }

    @Test
    void move_right() {
        assertThat(Point.first(true).move(positionZero)).isEqualTo(positionFirst);
    }

    @Test
    void bypass() {
        assertThat(Point.first(false).move(positionZero)).isEqualTo(positionZero);
    }
}