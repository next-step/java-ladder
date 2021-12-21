package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointTest {
    @Test
    void 생성_비교() {
        Point point = new Point(true);
        assertThat(point.isPoint()).isTrue();
    }
}
