package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void constructor() {
        assertThat(Point.of(true)).isEqualTo(Point.of(true));
    }

    @Test
    void move() {
        assertThat(Point.of(false).move(Point.of(true))).isEqualTo(1);
        assertThat(Point.of(true).move(Point.of(false))).isEqualTo(-1);
        assertThat(Point.of(false).move(Point.of(false))).isEqualTo(0);
    }
}
