package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void exception() {
        assertThatThrownBy(() -> {
            new Point(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void right() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void left() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void pass() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }


}
