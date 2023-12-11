package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 라인생성() {
        Line line = LineFactory.createLine(5, () -> true);
        assertThat(line.routeCount()).isEqualTo(2);
    }
}
