package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void move() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void next() {
        Point point = Point.first(true).next(new RandomValueGenerator());
        assertThat(point.move()).isEqualTo(Direction.LEFT);

        Point nextTruePoint = Point.first(false).next(() -> true);
        assertThat(nextTruePoint.move()).isEqualTo(Direction.RIGHT);

        Point nextFalsePoint = Point.first(false).next(() -> false);
        assertThat(nextFalsePoint.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.first(true).next(true));
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

     @Test
     void down() {
         Point point = Point.first(false).next(false);
         assertThat(point.move()).isEqualTo(Direction.DOWN);
     }

}
