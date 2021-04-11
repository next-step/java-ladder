package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void move_first_index() {
        // given
        int index = 0;
        Point point = Point.from(index, true);

        // when
        int expectedIndex = point.move();

        // then
        assertThat(++index).isEqualTo(expectedIndex);
    }

    @Test
    void move_right() {
        // given
        int index = 1;
        Point point = Point.from(index, true);

        // when
        int expectedIndex = point.move(false);

        // then
        assertThat(++index).isEqualTo(expectedIndex);
    }

    @Test
    void move_left() {
        // given
        int index = 1;
        Point point = Point.from(1, false);

        // when
        int expectedIndex = point.move(true);

        // then
        assertThat(--index).isEqualTo(expectedIndex);
    }

    @Test
    void not_move() {
        // given
        int index = 1;
        Point point = Point.from(1, false);

        // when
        int expectedIndex = point.move(false);

        // then
        assertThat(index).isEqualTo(expectedIndex);
    }
}