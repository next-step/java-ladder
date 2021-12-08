package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointElementTest {
    @Test
    void first1() {
        // given
        PointElement pointElement = PointElement.first(false);

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(PASS);
    }

    @Test
    void first2() {
        // given
        PointElement pointElement = PointElement.first(true);

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(RIGHT);
    }

    @Test
    void pass() {
        // given
        PointElement pointElement = PointElement.first(false).next(false);

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(PASS);
    }

    @Test
    void left() {
        // given
        PointElement pointElement = PointElement.first(true).next(false);

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(LEFT);
    }

    @Test
    void right() {
        // given
        PointElement pointElement = PointElement.first(false).next(true);

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(RIGHT);
    }

    @Test
    void last1() {
        // given
        PointElement pointElement = PointElement.first(true).last();

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(LEFT);
    }

    @Test
    void last2() {
        // given
        PointElement pointElement = PointElement.first(false).last();

        // when
        Direction direction = pointElement.move();

        // then
        assertThat(direction).isEqualTo(PASS);
    }
}
