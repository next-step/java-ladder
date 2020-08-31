package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void constructor() {
        assertThat(Point.of(true)).isEqualTo(Point.of(true));
    }

    @Test
    void isRight() {
        assertThat(Point.of(false).isRight(null)).isFalse();
        assertThat(Point.of(false).isRight(Point.of(false))).isFalse();
        assertThat(Point.of(false).isRight(Point.of(true))).isTrue();
    }
}
