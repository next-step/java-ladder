package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void 점_없음() {
        Point point = new Point(false);
        assertThat(point.isPresent()).isFalse();
    }

    @Test
    void 점_있음() {
        Point point = new Point(true);
        assertThat(point.isPresent()).isTrue();
    }
}