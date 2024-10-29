package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void 포인트_생성() {
        Point point = new Point();
        assertThat(point).isEqualTo(new Point());
    }
}
