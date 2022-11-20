package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomValueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @Test
    void left() {
        Point left = Point.first(true).next(false);
        Cross cross = new Cross(1, left);
        assertThat(cross.move()).isZero();
    }

    @Test
    void right() {
        Point right = Point.first(true);
        Cross cross = new Cross(1, right);
        assertThat(cross.move()).isEqualTo(2);
    }

    @Test
    void down() {
        Point down = Point.first(false).next(false);
        Cross cross = new Cross(1, down);
        assertThat(cross.move()).isOne();
    }

    @Test
    void first() {
        assertThat(Cross.first(true).move()).isOne();
        assertThat(Cross.first(false).move()).isZero();
    }

    @Test
    void next_stay() {
        Cross second = Cross.first(false).next(false);
        assertThat(second.move()).isOne();
    }

    @Test
    void next_left() {
        Cross second = Cross.first(true).next(false);
        assertThat(second.move()).isZero();
    }

    @Test
    void next_right() {
        Cross second = Cross.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    void next() {
        Cross second = Cross.first(true).next(new RandomValueGenerator());
        assertThat(second.move()).isZero();
    }

}
